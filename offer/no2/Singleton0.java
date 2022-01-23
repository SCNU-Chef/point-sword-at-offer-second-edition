package offer.no2;

/**
 * @author Toreno Li
 * 饿汉模式,线程安全
 */
public final class Singleton0 {
    private Singleton0() {
    }

    private static Singleton0 instance = new Singleton0();

    public static Singleton0 getInstance() {
        return instance;
    }
}
