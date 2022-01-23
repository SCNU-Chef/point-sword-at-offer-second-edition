package offer.no2;

/**
 * @author Toreno Li
 * 只适用于单线程环境
 */
public final class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
