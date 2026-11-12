package my.celium.org.guaranteedendships.fabric;

import my.celium.org.guaranteedendships.MissingMycel;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Fabric entrypoint. Without Mycel the mod stays idle and tells joining players Mycel is missing;
 * with it, {@link ShipsFabricHooks} starts the mod. This class must not
 * reference anything that loads Mycel.
 */
public final class ShipsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        if (!FabricLoader.getInstance().isModLoaded("mycel")) {
            MissingMycel.logOnce();
            ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> MissingMycel.tell(handler.getPlayer()));
            return;
        }
        ShipsFabricHooks.register();
    }
}
