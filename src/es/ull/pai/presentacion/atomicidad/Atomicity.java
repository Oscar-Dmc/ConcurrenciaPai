package es.ull.pai.presentacion.atomicidad;

public class Atomicity {

  public int c = 0;

  Atomicity () throws InterruptedException{
    //increment inc = new increment();
    //decrement dec = new decrement();
    //inc.start();
    //dec.start();
  }

  public void increment() {

    c+=5;
  }

  public void decrement() {

    c-=5;
  }

  public int value() {
    return c;
  }


  /**

  class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

}



import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }

}
   * @throws InterruptedException 


   **/
  public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    Atomicity test = new Atomicity();
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
   // for (int i = 0; i < 100; i++){
      test.c = 0;
      //System.runFinalization();
      System.out.println("Debe ser " + test.c);

      th1 p1 = new th1();
      th2 p2 = new th2();

      p1.start();
      //System.runFinalization();
      p2.start();
      //System.runFinalization();

      System.out.println(test.c);
    }

    //System.out.println(prove.c);

 // }

}
