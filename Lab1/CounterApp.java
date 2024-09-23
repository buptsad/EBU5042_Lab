public class CounterApp{
  public static void main(String[] args){
    Thread counter = new Counter();
    Thread sleepyCounter = new Thread(new SleepyCounter());
    counter.start();
    sleepyCounter.start();
    sleepyCounter.interrupt();
    System.out.println("Finished");
  }
}
