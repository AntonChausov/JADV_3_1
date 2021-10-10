import java.util.Random;

public class Toy extends Thread {

    final int TOY_SLEEP = 700;
    final int TOY_MIN_SLEEP = 300;
    private Tumbler tumbler;

    public Toy(String name) {
        super(name);
        tumbler = Tumbler.getInstance();
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (!isInterrupted()) {
            try {
                Thread.sleep(rnd.nextInt(TOY_SLEEP) + TOY_MIN_SLEEP);
            } catch (InterruptedException e) {
                turnoff();
                break;
            }
            if (tumbler.getCondition()) {
                turnoff();
            }
        }
    }

    private void turnoff() {
        tumbler.changeCondition(false);
        System.out.println("Tumbler turn off by " + this.getName());
    }
}
