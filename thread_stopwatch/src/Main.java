public class Main {
    public static void main(String[] args) {
        StopwatchThread thread1 = new StopwatchThread("Thread 1");
        StopwatchThread thread2 = new StopwatchThread("Thread 2");
        StopwatchThread thread3 = new StopwatchThread("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}