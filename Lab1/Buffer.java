public class Buffer {

    private int[] buf; // buffer storage
    private int last; // last occupied position

    public Buffer(int sz) {
        buf = new int[sz];
        last = 0;
    }

    public boolean isFull() {
        return (last == buf.length);
    }

    public boolean isEmpty() {
        return (last == 0);
    }

    public synchronized void put(int c) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        buf[last++] = c;
        notify();
    }

    public synchronized int get() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        int c = buf[0];
        System.arraycopy(buf, 1, buf, 0, --last);
        notify();
        return c;
    }
}
