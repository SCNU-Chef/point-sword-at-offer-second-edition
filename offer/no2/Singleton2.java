package offer.no2;

/**
 * @author Toreno Li
 * 每次都需要加锁,非常耗时
 */
public final class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        synchronized (Singleton2.class) {
            if (instance == null) {
                instance = new Singleton2();
            }
        }
        return instance;
    }

}
