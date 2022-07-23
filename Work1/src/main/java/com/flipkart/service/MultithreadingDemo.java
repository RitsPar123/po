//package com.flipkart.service;
//
//import com.flipkart.service.DB;
//import com.flipkart.service.MultiThreading;
//import com.flipkart.service.threadClass;
//
//
//import java.io.IOException;
//import java.util.concurrent.Callable;
//
//public class MultithreadingDemo implements Callable<Integer> {
//    Doctor k;
//    User U;
//
//    public MultithreadingDemo(Doctor k, User U) throws InterruptedException, IOException {
//        threadClass.DoctorCall(k, U);
//        System.out.println("yes it is working");
//    }
//
//    @Override
//    public Integer call() throws Exception {
//        return 12;
//    }
//
//
//}
