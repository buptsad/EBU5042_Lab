public class SleepyCounter implements Runnable {
  public int count = 50;

  public void run(){
    for(int i=50;i<=100;i++){
      System.out.println(count);
      count ++;
      try{
        Thread.sleep(50);
      } catch(InterruptedException e){
        e.printStackTrace();
        break;
      }
    }
    return;
  }

  public static void main(String[] args){
    Thread sleepyCounter = new Thread(new SleepyCounter());
    sleepyCounter.start();
    return;
  }
}
