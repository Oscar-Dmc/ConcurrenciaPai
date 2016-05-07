package es.ull.pai.presentacion.atomicidad;

public class AtomicitySync {

  private int c = 0;

  public synchronized void increment() {
    
    c +=5;
  }

  public synchronized void decrement() {
    c -=5;
  }

  public synchronized int value() {
    return c;
  }



  public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    AtomicitySync test = new AtomicitySync();
    class th1 extends Thread {
      public void run (){
        test.increment();
      }
    }
    class th2 extends Thread {
      public void run (){
        test.decrement();
      }
    }
    //for (int i = 0; i < 100; i++){
      test.c = 0;
      //System.runFinalization();
      System.out.println("Debe ser sync " + test.c);

      th1 p1 = new th1();
      th2 p2 = new th2();

      p1.start();
      //System.runFinalization();
      p2.start();
      //System.runFinalization();

      System.out.println(test.c);
    //}

  }

}
