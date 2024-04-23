public class Waiter {
    private final Fork[] forks;

    public Waiter(Fork[] forks) {
        this.forks = forks;
    }

    public synchronized void pickUpForks(Fork leftFork, Fork rightFork) throws InterruptedException {
        while (!isAvailable(leftFork, rightFork)) {
            wait();
        }
        // Mark forks as taken
        leftFork.setTaken(true);
        rightFork.setTaken(true);
    }

    public synchronized void putDownForks(Fork leftFork, Fork rightFork) {
        leftFork.setTaken(false);
        rightFork.setTaken(false);
        // Notify waiting philosophers that forks are available
        notifyAll();
    }

    private boolean isAvailable(Fork leftFork, Fork rightFork) {
        return !leftFork.isTaken() && !rightFork.isTaken();
    }
}