package com.ek;

public  class Test {

  
  
  public static void main(String[] args) {
    int aa = 1;
    System.out.println(aa++);
    System.out.println(++aa);

    int i = 1;
    int j;
    j = i++;

    System.out.println(i);
    System.out.println(j);

    int a = 10, b = 4, c = 20, d = 6;
    System.out.println(a++ * b + c * --d);
    
    int k = 12;
    System.out.println(k+=k-=k*=k);

  }

 
}
