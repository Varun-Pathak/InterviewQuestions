public class PrintNosUsingThreads {

    private static final int MAX_COUNT = 100;
    private static int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

                printOddNumbers();

        }, "T1");
        Thread t2 = new Thread(() -> {

                printEvenNumbers();

        }, "T2");
        t1.start();
        t2.start();
    }

    public static void printOddNumbers() {

        while (count <= MAX_COUNT) {
            synchronized (lock) {
                if (count % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + count++);
                    lock.notify();
                }
            else{
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        }
    }

    public static void printEvenNumbers() {

        while (count <= MAX_COUNT){
            synchronized (lock){
            if (count % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + " : "+ count++);
                    lock.notify();
                }
            else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            }
        }
    }
}
