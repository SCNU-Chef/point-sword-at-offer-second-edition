package offer.no2;

/**
 * @author Toreno Li
 * 静态内部类,Java实现单例的终极方法
 */
public class Singleton5 {
    private Singleton5() {
    }

    private static class Inner {
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Inner.instance;
    }
}
