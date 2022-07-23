//package com.flipkart.service;
//
//
//import com.flipkart.App;
//
//import java.util.Date;
//import java.util.Scanner;
//
//import static com.flipkart.App.arr;
//import static com.flipkart.service.DB.hvq;
//import static java.lang.Thread.sleep;
//
//public class MultiThreading extends App {
//    static Scanner sc =new Scanner(System.in);
//    Date date=new Date();
//
//
//
//    public void running(){
//        Thread t1=new Thread(){
//
//            public void run(){
//                try {
//                    hvqCall();
//
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        Thread t2=new Thread(){
//            public void run(){
//                try {
//                    rtoq1Call();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//        Thread t3=new Thread(){
//
//            public void run(){
//                try {
//                    hvqCall();
//
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        Thread t4=new Thread(){
//            public void run(){
//                try {
//                    rtoq1Call();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };Thread t5=new Thread(){
//
//            public void run(){
//                try {
//                    hvqCall();
//
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        Thread t6=new Thread(){
//            public void run(){
//                try {
//                    rtoq1Call();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };Thread t7=new Thread(){
//
//            public void run(){
//                try {
//                    hvqCall();
//
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        Thread t8=new Thread(){
//            public void run(){
//                try {
//                    rtoq1Call();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };Thread t9=new Thread(){
//
//            public void run(){
//                try {
//                    hvqCall();
//
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        Thread t10=new Thread(){
//            public void run(){
//                try {
//                    rtoq1Call();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//        t1.start();
//
//        t2.start();
//
//        t3.start();
//        t4.start();t5.start();
//        t6.start();t7.start();
////        t8.start();t9.start();
////        t10.start();
//    }
//
////    static Thread t3=new Thread(){
////        public void run(){
////            try {
////                method3();
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////        }
////    };
//public static String call(Doctor k, User U) throws InterruptedException {
//    System.out.println(k.id+" calls "+U.name+" having userid "+U.UserId+"\n");
//    sleep(10000);
//    //return "Unanswer";
//    //return "answer,unresolved,calldrop";
//    //return "answer,unresolved,callbusy";
//
//    return "answerresolved";
//
//}
//    /*public static void hvqCall() throws InterruptedException {
//
//        System.out.println("running hvqCall");
//        if (hvq.size() == 0)
//            return ;
//        else {
//            User U = hvq.getFirst();
//            hvq.removeFirst();
//
//            if (doctorAvailable("hv")) {
//
//                Doctor k=firstDoctor("hv");
//                DoctorCall(k,U);
////                hvqCall();
//            }
//            else if (doctorAvailable("slot")) {
//                Doctor k=firstDoctor("slot");
//                DoctorCall(k,U);
////                hvqCall();
//            }
//            else if (doctorAvailable("immediate")) {
//                Doctor k=firstDoctor("immediate");
//                DoctorCall(k,U);
////                hvqCall();
//            } else {
//                hvq.addFirst(U);
//            }
//
//
//        }
//    }*/
//    public void hvqCall() throws InterruptedException {
//
//        System.out.println("running hvqCall");
//
//        if (hvq.size() == 0)
//            return;
//
//        else {
//
//                User U = hvq.removeFirst();
//                //System.out.println(U.UserId);
//                Doctor k=firstDoctor("hv");
//
//                if(k!=null)
//                {
//                    System.out.println(k.id+" "+U.UserId);
//
//                    DoctorCall(k,U);
//                    return ;
//                }
//                k=firstDoctor("slot");
//                if(k!=null)
//                {
//                    System.out.println(k.id+" "+U.UserId);
//                    DoctorCall(k,U);
//                }
//                k=firstDoctor("immediate");
//                if(k!=null)
//                {
//                    System.out.println(k.id+" "+U.UserId);
//                    DoctorCall(k,U);
//                }
//                hvq.addFirst(U);
//                return ;
//            /*if (doctorAvailable("hv")) {
//
//                Doctor k = firstDoctor("hv");
//                DoctorCall(k, U);
////                hvqCall();
//            } else if (doctorAvailable("slot")) {
//                Doctor k = firstDoctor("slot");
//                DoctorCall(k, U);
////                hvqCall();
//            } else if (doctorAvailable("immediate")) {
//                Doctor k = firstDoctor("immediate");
//                DoctorCall(k, U);
////                hvqCall();
//            } else {
//                hvq.addFirst(U);
//            }*/
//
//
//        }
//    }
//    public static void rtoq1Call() throws InterruptedException {
//        System.out.println("running rtoq1Call");
//        if (rtoq1.size() == 0)
//            return;
//        else {
//            User U = rtoq1.removeFirst();
//
//
//            Doctor k=firstDoctor("immediate");
//            if(k!=null)
//            {
//                DoctorCall(k,U);
//                return ;
//            }
//            k=firstDoctor("slot");
//            if(k!=null)
//            {
//                DoctorCall(k,U);
//            }
//            k=firstDoctor("hvq");
//            if(k!=null)
//            {
//                DoctorCall(k,U);
//            }
//            rtoq1.addFirst(U);
//            return ;
//
//
//        }
//    }
//
//
//        /*public static void rtoq1Call() throws InterruptedException {
//        System.out.println("running rtoq1Call");
//        if (rtoq1.size() == 0)
//            return;
//        else {
//            User U = rtoq1.getFirst();
//            rtoq1.removeFirst();
//
//            if (doctorAvailable("immediate")) {
//
//                Doctor k=firstDoctor("immediate");
//
//                DoctorCall(k,U);
//
////                rtoq1Call();
//            } else if (doctorAvailable("slot")) {
//                Doctor k=firstDoctor("slot");
//                DoctorCall(k,U);
////                rtoq1Call();
//            } else if (doctorAvailable("hv")) {
//                 Doctor k=firstDoctor("hv");
//                DoctorCall(k,U);
////                rtoq1Call();
//            } else {
//                rtoq1.addFirst(U);
//            }
//
//
//        }
//    }*/
//   /* synchronized public static boolean  doctorAvailable(String role)
//    {
//
//        System.out.println("doctor available function working");
//        for(int i=0;i<10;i++)
//        {
//            if(!arr[i].busy)
//            {                 System.out.println("returning true");
//                return true;}
//        }
//        return false;
//    }*/
//    /*public static void placeCall(User U, String role) throws InterruptedException {
//        System.out.println("place call function working");
//
//
//
//
//    }*/
//    synchronized public static Doctor firstDoctor(String role)
//    {
//        for(int i=0;i<10;i++)
//        {
//            if(arr[i].busy==false&&arr[i].role==role){
//                main.arr[i].busy=true;
//                System.out.println(arr[i].id + " is busy");
//                return main.arr[i];
//            }
//
//
//        }
//        return null;     //will change it later
//    }
//    public static void DoctorCall(Doctor k, User U) throws InterruptedException {
//        Date date=new Date();
////        k.busy=true;
//
//        U.callattempt++;
//        String M=call(k,U);
//        System.out.println("write for "+k.id+" and "+U.UserId);
//
//
//        switch (M)
//        {
//            case "unanswer":
//
//                long timeMilli = date.getTime();
//                U.intime=timeMilli;
//                U.missedcall++;
//                if(U.missedcall>=2) {
//                    System.out.println("order is cancelled of user " + U.name + " having user id " + U.UserId + "\n");
//                    return;
//                }
//                wtschedq.addFirst(U);
//                U.inwtschedq=true;
//                System.out.println("User will be given option of link and callBack for 15 mins\n");
//                break ;
//            case "answerresolved":
//                System.out.println("order further processing");
//                break;
//            case "answerunresolvedcallbusy":
//
//                timeMilli = date.getTime();
//                U.intime=timeMilli;
//                wtschedq.addFirst(U);
//                U.inwtschedq=true;
//                System.out.println("User will be given option of link and callBack for 15 mins\n");   //when we do automaticallschedule make sure that we schedule call after 1 hour
//            case "answerunresolvedcalldrop":
//                if(U.callattempt>=3)
//                {
//                    System.out.println("order is cancelled of user " + U.name + " having user id " + U.UserId + "\n");
//                    return;
//                }
//                DoctorCall(k,U);
//
//
//                break;
//            default:
//                break;
//        }
//
//
//
//        k.noofcall++;
//        if(k.noofcall>8)
//        {
//
//            long timeMilli = date.getTime();
//            k.time=timeMilli;
//        }
//        k.busy=false;
//        System.out.println(k.id + " is free");
//    }
//
//
//    /*public void wantScheduleSlot(User U)
//    {
//        Vector<Integer> A=showAvailableSlot();
//        System.out.println("pick one slot from available slots\n");
//        String M=sc.next();
//        String[] tokens=M.split(" ");
//        int hr;
//        if(tokens[0]=="nextday")
//        {
//
//            hr=Integer.parseInt(tokens[1]);
//            hr=hr+24;
//            if(tokens[2]=="pm")
//                hr=hr+12;
//        }
//        else {
//            hr=Integer.parseInt(tokens[0]);
//            if(tokens[1]=="pm")
//                hr=hr+12;
//        }
//
//
//        scheduleSlot(U,hr);
//
//        System.out.println("your call successfully scheduled at "+M+"\n");
//    }
//    public void scheduleSlot(User U,int hr)
//    {
//        addSlot(U,hr);
//    }
//
//    public void deleteSlot(User U,int hr)
//    {
//        countUserPerhour[hr]--;
//        for(int i=0;i<18;i++)
//        {
//            if(scharray[hr][i].UserId==U.UserId)
//            {
//                User dummyUser=new User(-1,"abc","123",9);
//                scharray[hr][i]=dummyUser;
//
//            }
//        }
//    }
//
//
//    public int firstslotavailable()
//    {
//        int currenthr=date.getHours();
//        for(int i=currenthr;i<22;i++)
//        {
//            if(countUserPerhour[i]<18)
//            {
//
//
//                return i;
//            }
//        }
//        for(int i=32;i<48;i++)
//        {
//            if(countUserPerhour[i]<18)
//            {
//
//
//                return i;
//            }
//        }
//        return 32;
//    }
//
//
//    public void callBack(User U)
//    {
//        rtoq1.addFirst(U);
//        U.inwtschedq=false;
//    }
//    public void clickOnLink(User U)
//    {
//
//        wantScheduleSlot(U);
//
//
//
//
//    }*/
//
//
//
//
//
//
//}
