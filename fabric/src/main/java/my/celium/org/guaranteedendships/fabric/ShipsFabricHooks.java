package my.celium.org.guaranteedendships.fabric;

import my.celium.org.guaranteedendships.ShipsMod;

/** The real mod on Fabric, started only when Mycel is installed. */
final class ShipsFabricHooks {
    private ShipsFabricHooks() {
    }

    static void register() {
        ShipsMod.init();
    }
}
