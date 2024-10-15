public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 0; i < 250; i++) {
            System.out.println(buffer.get());
        }
    }
}
