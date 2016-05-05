package es.ull.pai.presentacion.atomicidad;

public class Suma {
  private int x = 0;

  class SumaTres extends Thread {
    public void run() {
      setX(getX() + 3);
    }
  }

  class SumaCinco extends Thread {
    public void run() {
      setX(getX() + 5);
    }
  }

  public Suma() {
    SumaTres tres = new SumaTres();
    SumaCinco cinco = new SumaCinco();

    tres.start();
    cinco.start();
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      
      Suma suma = new Suma();
      System.out.println(suma.getX());
    }
  }
}
