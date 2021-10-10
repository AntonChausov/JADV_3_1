public class Main {

    public static void main(String[] args) throws InterruptedException {
        User thUser = new User("User");
        thUser.start();

        Toy thToy = new Toy("Box");
        thToy.start();

        thUser.join();
        if (!thUser.isAlive()) {
            thToy.interrupt();
        }

    }
}
