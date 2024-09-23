public class CounterApp{
  public static void main(String[] args){
    Thread counter = new Counter();
    Thread sleepyCounter = new Thread(new SleepyCounter());
    counter.start();
    sleepyCounter.start();
    try{
      Thread.sleep(100);
    }catch (InterruptedException e){
      e.printStackTrace();
    }
    sleepyCounter.interrupt();
  }
}
