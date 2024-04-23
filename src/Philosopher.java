public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Waiter waiter;

    Philosopher(int id, Fork leftFork, Fork rightFork, Waiter waiter) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.waiter = waiter;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println("Philosopher" + id + " " + action);
        Thread.sleep(((int) (Math.random() * 3 * 1000)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(": Thinking");
                waiter.pickUpForks(leftFork, rightFork);
                doAction(": Eating");
                waiter.putDownForks(leftFork, rightFork);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}