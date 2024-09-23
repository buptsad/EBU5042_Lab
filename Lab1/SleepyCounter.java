public class SleepyCounter implements Runnable {
  public int count = 10;

  public void run(){
    for(int i=10;i<=500;i++){
      System.out.println(count);
      count ++;
      if (Thread.interrupted()){
        System.out.println("Interrupted!");
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
