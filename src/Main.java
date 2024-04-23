public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i + "");
        }

        Waiter waiter = new Waiter(forks);

        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % 5];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, waiter);
            new Thread(philosophers[i]).start();
        }
    }
}