package my.celium.org.guaranteedendships.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import my.celium.org.guaranteedendships.EndShips;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.structures.EndCityPieces;
import net.minecraft.world.level.levelgen.structure.structures.EndCityStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

/** Lets {@link EndShips} lay the city out again until it has a ship. */
@Mixin(EndCityStructure.class)
public abstract class EndCityStructureMixin {
    @Redirect(method = "generatePieces", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/structure/structures/EndCityPieces;startHouseTower(Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureTemplateManager;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Rotation;Ljava/util/List;Lnet/minecraft/util/RandomSource;)V"))
    private void guaranteedendships$layOut(StructureTemplateManager manager, BlockPos pos, Rotation rotation,
            List<StructurePiece> pieces, RandomSource random) {
        EndShips.layOut(EndCityPieces::startHouseTower, manager, pos, rotation, pieces, random);
    }
}
