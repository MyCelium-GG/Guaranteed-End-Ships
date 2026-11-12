package my.celium.org.guaranteedendships.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;

@Mixin(TemplateStructurePiece.class)
public interface TemplatePieceAccessor {
    @Accessor("templateName")
    String guaranteedendships$templateName();
}
