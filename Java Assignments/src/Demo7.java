class NumberPrinter implements Runnable {
    private String threadName;

    public NumberPrinter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                Thread.sleep(500); // Pause for 500ms to simulate work
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
    }
}

public class Demo7 {
    public static void main(String[] args) {
        NumberPrinter printer1 = new NumberPrinter("Thread 1");
        NumberPrinter printer2 = new NumberPrinter("Thread 2");

        Thread thread1 = new Thread(printer1);
        Thread thread2 = new Thread(printer2);

        thread1.start();
        thread2.start();
    }
}
