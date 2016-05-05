package es.ull.pai.presentacion.atomicidad;

public class Suma {
  public static int x = 0;

  class SumaTres extends Thread {
    public void run() {
      x++
      ;
    }
  }

  class SumaCinco extends Thread {
    public void run() {
      x++;
    }
  }

  public Suma() throws InterruptedException {
    SumaTres tres = new SumaTres();
    SumaCinco cinco = new SumaCinco();

    tres.start();
    cinco.start();
    for (int i = 0; i < 10; i++) {
      tres.join();
      cinco.join();

    }


  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public static void main(String[] args) throws InterruptedException {
    Suma suma = new Suma();
    System.out.println("final: " + x);

  }
}
