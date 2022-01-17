package hello.core.singletonTest;

public class SingletonServcie {

    private static final SingletonServcie instance = new SingletonServcie();

    public static SingletonServcie getInstance() {
        return instance;
    }

    private SingletonServcie() {

    }

    public static void main(String[] args) {
        SingletonServcie s1 = new SingletonServcie();
        SingletonServcie s2 = new SingletonServcie();

    }
}
