package my.celium.org.guaranteedendships;

import my.celium.org.Mycel;
import my.celium.org.config.ConfigBuilder;
import my.celium.org.config.ConfigValue;
import my.celium.org.config.MycelConfig;
import my.celium.org.metadata.ModMetadata;

/**
 * Guaranteed End Ships: every newly generated End city comes with an End ship.
 *
 * <p>Only runs when Mycel is installed; the loader entrypoints check that first and fall back to
 * {@link MissingMycel} otherwise. The generation hook asks {@link ShipGate} before it touches
 * this class.
 */
public final class ShipsMod {
    public static final String ID = "guaranteedendships";
    public static final String NAME = "Guaranteed End Ships";

    public static final ModMetadata META = ModMetadata.builder(ID, NAME, "1.0.0")
            .author("MyCelium")
            .website("https://www.curseforge.com/minecraft/mc-mods/guaranteed-end-ships")
            .updateUrl("https://wiki.mycelium-gg.org/updates/guaranteedendships.json")
            .build();

    public static ConfigValue<Boolean> enabled;
    public static ConfigValue<Integer> shipChance;
    public static MycelConfig config;

    private ShipsMod() {
    }

    /** Called once from each loader's entrypoint, only when Mycel is installed. */
    public static void init() {
        Mycel.initialize();
        Mycel.registerMod(META);

        ConfigBuilder builder = Mycel.config(META);
        enabled = builder.booleanValue("enabled", true,
                "Whether new End cities are made to have an End ship.");
        shipChance = builder.intValue("shipChance", 100, 0, 100,
                "Percent of new End cities that get an End ship. 100 means every city; vanilla is roughly 1 in 5.");
        config = builder.build();
        ShipGate.open();
    }

    /** Percent chance (0 to 100) that a new End city must have a ship. */
    public static int chance() {
        if (!Mycel.isEnabled(ID) || !enabled.get()) {
            return 0;
        }
        return shipChance.get();
    }
}
