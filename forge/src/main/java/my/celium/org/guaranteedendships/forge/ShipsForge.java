package my.celium.org.guaranteedendships.forge;

import my.celium.org.guaranteedendships.MissingMycel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Forge entrypoint. Without Mycel the mod stays idle and tells joining players Mycel is missing;
 * with it, {@link ShipsForgeHooks} starts the mod. This class must not
 * reference anything that loads Mycel.
 */
@Mod("guaranteedendships")
public final class ShipsForge {
    public ShipsForge(@SuppressWarnings("unused") FMLJavaModLoadingContext context) {
        if (!ModList.isLoaded("mycel")) {
            MissingMycel.logOnce();
            PlayerEvent.PlayerLoggedInEvent.BUS.addListener(event -> {
                if (event.getEntity() instanceof ServerPlayer player) {
                    MissingMycel.tell(player);
                }
            });
            return;
        }
        ShipsForgeHooks.register();
    }
}
