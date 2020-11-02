package com.training.assignments;
public class Forloop {
public int meth(){
    int n = 500;
    int i;
    System.out.print("middle number ");
    for ( i = 1; i <= n; i++) {
        n--;
        if ((n / 2)==250) {
            return i;
        }
        break;
    }
    return i;
}


    public static void main(String[] args) {
   Forloop l=new Forloop();
  int i= l.meth();
        System.out.println(i);
    }
}