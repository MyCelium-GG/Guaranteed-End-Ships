package my.celium.org.guaranteedendships.neoforge;

import my.celium.org.guaranteedendships.ShipsMod;

/** The real mod on NeoForge, started only when Mycel is installed. */
final class ShipsNeoForgeHooks {
    private ShipsNeoForgeHooks() {
    }

    static void register() {
        ShipsMod.init();
    }
}
