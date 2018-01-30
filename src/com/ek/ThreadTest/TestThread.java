package com.ek.ThreadTest;

public class TestThread {

  static TestThread.run r= new TestThread().new run();
  
  public static void main(String[] args) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          r.asSub();
        }
      }
    }).start();
    
    
    
    for (int i = 0; i < 5; i++) {
        r.asMain();
    }
    

  }

   class run {

    private boolean tag = false;

    public synchronized void asSub() {
      while (tag) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      for (int j = 0; j < 5; j++) {
        System.out.println(Thread.currentThread().getName() + " Method Sub Thread Run! ");
      }
      tag = true;
      this.notify();
    }
    
    

    public synchronized void asMain() {
      while (!tag) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      for (int j = 0; j < 10; j++) {
        System.out.println(Thread.currentThread().getName() + " Method Main Thread Run! ");
      }
      tag = false;
      this.notify();
    }
  }
}
