public class Counter extends Thread{
  public int counter = 50;
  public void run() {
    for(int i=50;i<=100;i++){
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
