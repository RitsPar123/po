package com.flipkart.service;

import java.util.Date;

public class Doctor {

    public int id;
    public boolean busy;

    public String name;
    public String role;
    public int noofcall;
    public long time;
    public Doctor(int id,String name,String role)
    {
        this.id=id;
        this.busy=false;
        this.name=name;
        this.role=role;
        this.noofcall=0;

        Date date=new Date();
        this.time= date.getTime();
    }
    public int getId()
    {
        return id;
    }


}