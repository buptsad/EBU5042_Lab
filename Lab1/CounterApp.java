public class CounterApp{
  public static void main(String[] args){
    Thread counter = new Counter();
    Thread sleepyCounter = new Thread(new SleepyCounter());
    counter.start();
    sleepyCounter.start();
    sleepyCounter.interrupt();
    try{
      counter.join();
      sleepyCounter.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    System.out.println("Finished");
  }
}
