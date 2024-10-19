public class Counter extends Thread{
  public int counter = 10;
  public void run() {
    for(int i=10;i<=500;i++){
      System.out.println(counter);
      counter ++;
    }
    return;
  }

  public static void main(String[] args) {
    Counter counter = new Counter();
    counter.start();
  }
}
