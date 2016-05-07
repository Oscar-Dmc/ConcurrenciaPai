package es.ull.pai.presentacion.atomicidad;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicityAtom {
  private AtomicInteger c = new AtomicInteger(0);

  public void increment() {
      c.addAndGet(5);
  }

  public void decrement() {
      c.addAndGet(-5);
  }

  public int value() {
      return c.get();
  }


/**

public class AtomicityAtom {

  private AtomicInteger c = new AtomicInteger(0);

  public synchronized void increment() {
    c +=5;
  }

  public synchronized void decrement() {
    c -=5;
  }

  public synchronized int value() {
    return c;
  }

**/

  public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    AtomicityAtom test = new AtomicityAtom();
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
      test.c.set(0);
      //System.runFinalization();
      System.out.println("Debe ser atom " + test.c);

      th1 p1 = new th1();
      th2 p2 = new th2();

      p1.start();
      System.runFinalization();
      p2.start();
      System.runFinalization();

      System.out.println(test.c);
    //}

  }

}
