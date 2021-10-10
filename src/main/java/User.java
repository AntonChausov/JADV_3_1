import java.util.Random;

public class User extends Thread {

    final int SLEEP = 2000;
    final int MIN_SLEEP = 500;
    final int COUNT = 5;
    private Tumbler tumbler;

    public User(String name) {
        super(name);
        tumbler = Tumbler.getInstance();
    }

    @Override
    public void run() {
        Random rnd = new Random();
        for (int i = 0; i < COUNT; i++) {
            try {
                Thread.sleep(rnd.nextInt(SLEEP) + MIN_SLEEP);
                tumbler.changeCondition(true);
                System.out.println("Tumbler turn on by " + this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

