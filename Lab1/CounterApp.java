public class CounterApp{
  public static void pleaseFinish(Thread threadNeedsFinish) throws InterruptedException{
    threadNeedsFinish.interrupt();
    return;
  }
  public static void main(String[] args){
    Thread counter = new Counter();
    Thread sleepyCounter = new Thread(new SleepyCounter());
    counter.start();
    sleepyCounter.start();
    try{
      CounterApp.pleaseFinish(sleepyCounter);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    try{
      counter.join();
      sleepyCounter.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    System.out.println("Finished");
  }
}
