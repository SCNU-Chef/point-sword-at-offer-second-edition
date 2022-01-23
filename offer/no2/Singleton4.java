package offer.no2;

/**
 * @author Toreno Li
 * 实现起来较为复杂
 */
public final class Singleton4 {
    private Singleton4() {
    }

    private static volatile Singleton4 instance = null;

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}
