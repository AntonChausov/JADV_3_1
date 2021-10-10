public class Tumbler {
    private static Tumbler instance;
    volatile boolean condition;

    public Tumbler() {
        condition = false;
    }

    public static Tumbler getInstance() {
        if (instance == null) {
            instance = new Tumbler();
        }
        return instance;
    }

    public boolean getCondition() {
        return condition;
    }

    public void changeCondition(boolean condition) {
        this.condition = condition;
    }
}
