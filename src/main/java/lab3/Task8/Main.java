package lab3.Task8;

public class Main {
    public static void main(String[] args) {
        Greeter greeter1 = new Greeter(5, "Ilya");
        Greeter greeter2 = new Greeter(3, "Yuriy&Egor");

        Thread[] threads = { new Thread(greeter1), new Thread(greeter2) };
        for (Thread thread: threads) {
            thread.start();
        }
    }
}
