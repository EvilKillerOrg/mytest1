package com.ek.SingletonDemo;

public class SingletonDemo {

  private SingletonDemo() {

  }

  // 饿汉
  // private static SingletonDemo s = new SingletonDemo();
  // public static SingletonDemo getInstanec(){
  // return s;
  // }

  // 懒汉
  // private static SingletonDemo s;
  // public static synchronized SingletonDemo getInstanec(){
  // if(s==null){
  // s = new SingletonDemo();
  // }
  // return s;
  // }

  // 静态内部类
   private static class innerClass{
   private static final SingletonDemo instance = new SingletonDemo();
   }
   public static SingletonDemo getInstance(){
   return innerClass.instance;
   }



}
