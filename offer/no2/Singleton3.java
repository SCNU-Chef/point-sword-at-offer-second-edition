package offer.no2;

/**
 * @author Toreno Li
 * instance = new Singleton3()可能发生指令重排序
 */
public final class Singleton3 {
    private Singleton3() {
    }

    private static Singleton3 instance = null;

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

}
