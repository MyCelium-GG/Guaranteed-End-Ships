package my.celium.org.guaranteedendships;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

/**
 * Makes an End city come with a ship. Vanilla only builds a ship at the end of a bridge, with a
 * small chance, so most cities have none. When a city comes out without one, it is laid out again
 * with the next random numbers until a layout has a ship. Every city is still an ordinary vanilla
 * city, just one of the layouts that has a ship. Cities that already exist are not changed.
 */
public final class EndShips {
    /** Layouts tried per city before giving up and keeping the last one. */
    static final int MAX_TRIES = 200;

    /** Builds one city layout into the given list, like vanilla's {@code startHouseTower}. */
    @FunctionalInterface
    public interface Layout {
        void build(StructureTemplateManager manager, BlockPos pos, Rotation rotation, List<StructurePiece> pieces,
                RandomSource random);
    }

    private EndShips() {
    }

    /** Lays out a city, again and again if needed, so it has a ship when the settings ask for one. */
    public static void layOut(Layout vanilla, StructureTemplateManager manager, BlockPos pos, Rotation rotation,
            List<StructurePiece> pieces, RandomSource random) {
        vanilla.build(manager, pos, rotation, pieces, random);
        if (!ShipGate.isOpen() || hasShip(pieces)) {
            return;
        }
        int chance = ShipsMod.chance();
        if (chance <= 0 || chance < 100 && random.nextInt(100) >= chance) {
            return;
        }
        for (int i = 1; i < MAX_TRIES && !hasShip(pieces); i++) {
            pieces.clear();
            vanilla.build(manager, pos, rotation, pieces, random);
        }
    }

    static boolean hasShip(List<StructurePiece> pieces) {
        for (StructurePiece piece : pieces) {
            if (piece instanceof TemplateStructurePiece template && isShip(template)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isShip(TemplateStructurePiece piece) {
        String name = ((my.celium.org.guaranteedendships.mixin.TemplatePieceAccessor) piece).guaranteedendships$templateName();
        return name != null && (name.equals("ship") || name.endsWith("/ship") || name.endsWith(":ship"));
    }
}
