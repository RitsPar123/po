package com.flipkart.service;


import com.flipkart.service.makigobject.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

import static com.flipkart.service.DB.callback;
import static com.flipkart.service.DB.rtoq1;


@Path("/User")

public class UserRestAPI {
    @GET
    @Path("/helloworld")
    @Produces(MediaType.APPLICATION_JSON)
    public Response printingHelloWorld( ){
       /* try {
            return Response.status(200).entity(adminOpObj.viewPendingAdmissions()).build();
        } catch (Exception e) {
            return Response.status(409).entity(e.getMessage()).build();
        }*/
        String str = "hello world";
        hello h=new hello(str);
        String k="{"+h+"}";
        Object obj=k;
        return Response.status(200).entity(h).build();
//        return Response.status(200).entity("hello world").build();

    }

    @GET
    @Path("/changestatus")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changestatus(
            @QueryParam("id") int id
    ){

        User U=DB.getUser.get(id);
        int hr=U.hr;
        int min=U.min;
        int min1=min+5;

        String M=" ";
        if(hr>12)
        {   int j=hr-12;
            M=j+" pm - ";
        }
        else if(hr==12)
        {
            M=hr+" noon - ";
        }
        else if(hr==11)
        {
            M=hr+" am - ";
        }
        else
        {
            M=hr+" am - ";
        }

        if(hr>24) {
            hr = hr - 24;
            if (hr > 12) {
                int j = hr - 12;
                M="next_day " + j + " pm - ";
            } else if (hr == 12) {
                M="next_day " + hr + " noon - ";
            } else if (hr == 11) {
                M="next_day " + hr + " am - ";
            } else {
                M="next_day " + hr + " am - ";
            }
        }
        U.status="will get call at "+ M + " between "+min+" to "+min1+"minutes";
        U.summary=U.summary+"\n"+U.status;
        hello N=new hello(U.status);
        return Response.status(200).entity(N).build();

    }

    @POST
    @Path("/orderPlace")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response orderPlace(

            @Valid UserEntity entity
    )  {


                int price= entity.getPrice();
                String name= entity.getName();
                String number= entity.getNumber();
                User U = new User( name, number, price);

                DB.getUser.put(U.UserId,U);
                System.out.println(DB.getUser.get(U.UserId).name);


                Date date = new Date();
                int hr = date.getHours();
                if (hr>22||hr<8)      //will change it later to hr>22||hr<8
                {
                    // System.out.println("User will be given option of link for 15 mins\n");
                    U.inwtschedq = true;
                    DB.wtschedq.addFirst(U);
                    date = new Date();
                    U.intime=date.getTime();

                } else {
                    if (U.price > 1000) {
                        DB.hvq.addFirst(U);
                    } else {
                        DB.rtoq1.addFirst(U);
                    }
                }
                String str1 = "dear User " + name +" your order has been placed, you will get a call within 5 minutes";

                String str2="If you are busy,you can schedule your call by clicking on schedule call button";
                int id=U.UserId;
                justafterorderplace j=new justafterorderplace(id,str1,str2);
                return Response.status(200).entity(j).build();

//                return Response.status(200).entity("dear User " + U.name + " your order has been placed \n you will get a call within 15 minutes").build();





    }

    @POST
    @Path("/addslot")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addslot(
            @Valid addslotentity entity

    ) {
        int id= entity.getId();
        int hr= entity.getHr();
        User U=DB.getUser.get(id);
        System.out.println(U.name+"iska na uska");

        int k;
        try {
             U.inwtschedq=false;
             k=threadClass.addSlot(U,hr);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       hrmin M= new hrmin(hr,k);


        return Response.status(200).entity(M).build();









    }




    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response status(
           @QueryParam("id") int id
    ){

        try {
            System.out.println("ha doobe");



            System.out.println(id+"ramji");
            User U=DB.getUser.get(id);


            System.out.println(U);
            hello M=new hello(U.status);
            return Response.status(200).entity(M).build();
        } catch (Exception e) {
            return Response.status(409).entity(e.getMessage()).build();
        }

    }

    @GET
    @Path("/write")
    @Produces(MediaType.APPLICATION_JSON)
    public Response write(
            @QueryParam("id") int id
    ){

        try {


            System.out.println("ha doobe");



            System.out.println(id+"ramji");
            User U=DB.getUser.get(id);
            System.out.println(U.lastcallresult);

            if(U.choosedslot)
            {
                hello M=new hello("cs");
                return Response.status(200).entity(M).build();

            }
            else if(U.inwtschedq&& Objects.equals(U.lastcallresult, ""))
            {
                hello M=new hello("iw");
                return Response.status(200).entity(M).build();
            }

           if(Objects.equals(U.lastcallresult, "aucb"))
            {
                if(U.callattempt>=3)
                {

                    hello M=new hello("co");
                    return Response.status(200).entity(M).build();
                }

                hello M=new hello("aucb");
                return Response.status(200).entity(M).build();
            }
            else if(Objects.equals(U.lastcallresult, "aucd"))
            {
                if(U.callattempt>=3)
                {

                    hello M=new hello("co");
                    return Response.status(200).entity(M).build();
                }
                hello M=new hello("aucd");
                return Response.status(200).entity(M).build();
            }
            else if(Objects.equals(U.lastcallresult, "u"))
            {
                if(U.missedcall==2)
                {
                    hello M=new hello("co");
                    return Response.status(200).entity(M).build();
                }

                hello M=new hello("u");
                return Response.status(200).entity(M).build();
            }
            else if(Objects.equals(U.lastcallresult, "ar"))
            {
                hello M=new hello("s");
                return Response.status(200).entity(M).build();
            }
            else
            {
                hello M=new hello("nc");
                return Response.status(200).entity(M).build();
            }


        } catch (Exception e) {
            return Response.status(409).entity(e.getMessage()).build();
        }

    }
    @GET
    @Path("/callattempt")
    @Produces(MediaType.APPLICATION_JSON)
    public Response callattempt(
            @QueryParam("id") int id
    ){
        User U=DB.getUser.get(id);
        int k=U.callattempt;

        hello M=new hello(String.valueOf(k));
        return Response.status(200).entity(M).build();
    }

    @GET
    @Path("/callmissed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response callmissed(
            @QueryParam("id") int id
    ){
        User U=DB.getUser.get(id);
        int k=U.missedcall;

        hello M=new hello(String.valueOf(k));
        return Response.status(200).entity(M).build();
    }






    @GET
    @Path("/showavailableslots")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showavailableslots(
    ){

        try {
            Vector<Integer> A= threadClass.showAvailableSlot();

            String items[]=new String[A.size()];
            for(int k=0;k<A.size();k++)
            {
                int i=A.get(k);
                if(i>12)
                {   int j=i-12;
                    items[k]=j+" pm - "+(j+1)+" pm";
                }
                else if(i==12)
                {
                    items[k]=i+" noon - "+(i+1-12)+" pm";
                }
                else if(i==11)
                {
                    items[k]=i+" am - "+(i+1)+" noon";
                }
                else
                {
                    items[k]=i+" am - "+(i+1)+" am";
                }

                if(i>24) {
                    i = i - 24;
                    if (i > 12) {
                        int j = i - 12;
                        items[k]="next_day " + j + " pm - " + (j + 1) + " pm";
                    } else if (i == 12) {
                        items[k]="next_day " + i + " noon - " + (i + 1 - 12) + " pm";
                    } else if (i == 11) {
                        items[k]="next_day " + i + " am - " + (i + 1) + " noon";
                    } else {
                        items[k]="next_day " + i + " am - " + (i + 1) + " am";
                    }
                }
            }
            showavailableslots M=new showavailableslots(items);
            return Response.status(200).entity(M).build();
        } catch (Exception e) {
            return Response.status(409).entity(e.getMessage()).build();
        }

    }






    @GET
    @Path("/callback")
    @Produces(MediaType.APPLICATION_JSON)
    public Response callback(
            @NotNull
            @QueryParam("id") int id
    ) {
        User U=DB.getUser.get(id);
        U.inwtschedq=false;
        U.incallback=true;
        callback.addFirst(U);
//        System.out.println(rtoq1.size());
//        System.out.println(U.name);

        hello m=new hello("call back is working");

        return Response.status(200).entity(m).build();
    }










    }
