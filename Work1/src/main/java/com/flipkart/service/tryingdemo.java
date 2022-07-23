package com.flipkart.service;


import java.io.IOException;

public class tryingdemo extends Thread {
     public Doctor k;

     tryingdemo(Doctor k)
     {
         this.k=k;

     }

    public void run() {

        try {
//            System.out.println("thread object has started");
           User b= threadClass.userAvailable(k.role);

           if(b!=null)
           {
               threadClass.DoctorCall(k,b);
               System.out.println("this function is working");
           }
           k.busy=false;



        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}









