package my.celium.org.guaranteedendships;

/**
 * Whether the mod runs at all. It stays shut when Mycel is missing, and the mixin asks here first,
 * so it never loads a class that needs Mycel. Must never touch a Mycel class.
 */
public final class ShipGate {
    private static volatile boolean open;

    private ShipGate() {
    }

    static void open() {
        open = true;
    }

    public static boolean isOpen() {
        return open;
    }
}
