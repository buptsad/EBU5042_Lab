public class BufferApp {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(50);
        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));
        producer.start();
        consumer.start();
    }
}
