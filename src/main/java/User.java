import java.util.Random;

public class User extends Thread {

    final int USER_SLEEP = 2000;
    final int USER_MIN_SLEEP = 500;
    final int COUNT = 5;
    private Tumbler tumbler;

    public User(String name) {
        super(name);
        tumbler = Tumbler.getInstance();
    }

    @Override
    public void run() {
        Random rnd = new Random();
        int i = 0;
        while (i < COUNT) {
            try {
                Thread.sleep(rnd.nextInt(USER_SLEEP - USER_MIN_SLEEP) + USER_MIN_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!tumbler.getCondition()) {
                tumbler.changeCondition(true);
                System.out.println("Tumbler turn on by " + this.getName());
                i++;
            }
        }
    }

}

