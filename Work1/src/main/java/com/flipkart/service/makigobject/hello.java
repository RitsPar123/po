package com.flipkart.service.makigobject;

public class hello {
    public String str;

    public hello(String s) {
        this.str = s;
    }


    public static void main(String args[]) {
        hello h = new hello("ram");
        System.out.println(h.str);
    }

}