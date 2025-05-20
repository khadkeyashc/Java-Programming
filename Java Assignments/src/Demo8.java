class NumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500); // Delay of 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("NumberThread interrupted.");
            }
        }
    }
}

class LetterThread extends Thread {
    @Override
    public void run() {
        for (char letter = 'A'; letter <= 'J'; letter++) {
            System.out.println("Letter: " + letter);
            try {
                Thread.sleep(700); // Delay of 700 milliseconds
            } catch (InterruptedException e) {
                System.out.println("LetterThread interrupted.");
            }
        }
    }
}

public class Demo8 {
    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        LetterThread letterThread = new LetterThread();

        numberThread.start();
        letterThread.start();
    }
}

