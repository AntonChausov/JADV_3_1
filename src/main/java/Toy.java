
public class Toy extends Thread{

    private Tumbler tumbler;

    public Toy(String name) {
        super(name);
        tumbler = Tumbler.getInstance();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (tumbler.getCondition()){
                tumbler.changeCondition(false);
                System.out.println("Tumbler turn off by " + this.getName());
            }
        }

    }
}
