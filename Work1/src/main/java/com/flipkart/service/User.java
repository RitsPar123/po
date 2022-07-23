package com.flipkart.service;

import java.util.Date;

public class User {
    public  int UserId;
    public  String name;
    public  long intime;
    public  String number;
    public  int price;
    public int callattempt;
    public int missedcall;
    public boolean inwtschedq;
    public boolean inrtoq2;

    public String status;
    public String summary;
    public boolean busy;
    public String lastcallresult;
    public boolean choosedslot;
    public int hr;
    public int min;
    public boolean incallback;
    public User(String name,String number,int price)
    {
        this.UserId=DB.createID();

        this.name=name;

        Date date=new Date();
        this.intime= date.getTime();

        this.number=number;
        this.price=price;
        this.callattempt=0;
        this.missedcall=0;
        this.inwtschedq=false;
        this.inrtoq2=false;
        this.status="Doctor will call within 5 minutes";
        this.summary="order placed";
        this.busy=false;
        this.lastcallresult="";
        this.choosedslot=false;
        this.hr=-1;
        this.min=-1;
        this.incallback=false;
    }





}
