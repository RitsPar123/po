package com.flipkart.service;




import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;

public class DB{
    public static Deque<User> callback=new ArrayDeque<User>();
    public static Deque<User> hvq=new ArrayDeque<User>();
    public static Deque<User> rtoq1=new ArrayDeque<User>();
    public static Deque<User> rtoq2=new ArrayDeque<User>();
    public static User[][] scharray= new User[48][20];    //for now 24 hours,will change it later



    public static Deque<User> wtschedq=new ArrayDeque<User>();

    public static int[] countUserPerhour=new int[48];

    int limit2=2;
    public static HashMap<Integer,String> orderDetails=new HashMap<Integer,String>();
    public static HashMap<Integer,String> doctorDetails=new HashMap<Integer,String>();

    static HashMap<Integer,User> getUser=new HashMap<Integer,User>();

    public static User dummyUser=new User("abc","123",-1);
    private static int idCounter = 0;

    public static synchronized int createID()
    {
        return idCounter++;
    }

    public static String getlogMessage(String str){
        Date date=new Date();
        return "[ " + date + " ] " + str;
    }
    public static void updateMessage(int id, String str) throws IOException {
        String M=orderDetails.get(id);
        String N=getlogMessage(str);
        M=M+"\n"+N;

        orderDetails.put(id,M);
        FileWriter fileWritter = new FileWriter("orderdetatils" + id+ ".txt",true);
        fileWritter.append(N+"\n");
        fileWritter.close();
    }
    public static void updatedoctorMessage(int id, String str) throws IOException {
        String M=doctorDetails.get(id);
        String N=getlogMessage(str);
        M=M+"\n"+N;
        doctorDetails.put(id,M);
        FileWriter fileWritter = new FileWriter("doctordetatils" + id+ ".txt",true);
        fileWritter.append(N+"\n");
        fileWritter.close();
    }




    public static void showhvq()
    {   System.out.println("showing hvq");
        for(User U:hvq)
        {
            System.out.println(U.UserId+ " "+U.name+" "+U.price);
        }
    }
    public static void showrtoq1()
    {   System.out.println("showing rtoq1");
        for(User U:rtoq1)
        {
            System.out.println(U.UserId+ " "+U.name+" "+U.price);
        }
    }
    public static void showrtoq2()
    {   System.out.println("showing rtoq2");
        for(User U:rtoq2)
        {
            System.out.println(U.UserId+ " "+U.name+" "+U.price);
        }
    }
    public static void showwtschedq()
    {   System.out.println("showing wtschedq");
        for(User U:wtschedq)
        {
            System.out.println(U.UserId+ " "+U.name+" "+U.price);
        }
    }
    public static int limit=5;




}
