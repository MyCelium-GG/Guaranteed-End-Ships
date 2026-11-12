package my.celium.org.guaranteedendships.forge;

import my.celium.org.guaranteedendships.ShipsMod;

/** The real mod on Forge, started only when Mycel is installed. */
final class ShipsForgeHooks {
    private ShipsForgeHooks() {
    }

    static void register() {
        ShipsMod.init();
    }
}
