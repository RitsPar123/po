//package com.flipkart.service;
//
//
//
//import java.util.*;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class paralllel extends main {
//
//    Date date = new Date();
//    Scanner sc = new Scanner(System.in);
//    User dummy = new User( "abs", "123", 45);
//    public void running()
//    {
//        //create a callable for each method
//        Callable<Void> callable1 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                hvqCall();
//                return null;
//            }
//        };
//
//        Callable<Void> callable2 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                rtoq1Call();
//                return null;
//            }
//        };
//
//        Callable<Void> callable3 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                rtoq2Call();
//                return null;
//            }
//        };Callable<Void> callable4 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                wtschedqexpire();
//                return null;
//            }
//        };
//
//        Callable<Void> callable5 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                hvqexpire();
//                return null;
//            }
//        };
//
//        Callable<Void> callable6 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                rtoq1expire();
//                return null;
//            }
//        };Callable<Void> callable7 = new Callable<Void>() {
//            @Override
//            public Void call() throws Exception {
//                rtoq2expire();
//                return null;
//            }
//        };
//
//
//
//        //add to a list
//        List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
//        taskList.add(callable1);
//        taskList.add(callable2);
//        taskList.add(callable3);
//        taskList.add(callable4);
//        taskList.add(callable5);
//        taskList.add(callable6);
//        taskList.add(callable7);
//
//
//        //create a pool executor with 3 threads
//        ExecutorService executor = Executors.newFixedThreadPool(7);
//
//        try {
//            //start the threads and wait for them to finish
//            executor.invokeAll(taskList);
//
//        } catch (InterruptedException ie) {
//            //do something if you care about interruption;
//        }
//        executor.shutdown();
//    }
//
//
//    public void hvqCall() {
//        System.out.println("running hvqCall");
//        if (hvq.size() == 0)
//            return ;
//        else {
//            User U = hvq.getFirst();
//            hvq.removeFirst();
//
//            if (doctorAvailable("hv")) {
//
//                placeCall(U, "hv");
//                hvqCall();
//            }
//            else if (doctorAvailable("slot")) {
//                placeCall(U, "slot");
//                hvqCall();
//            }
//            else if (doctorAvailable("immediate")) {
//                placeCall(U, "immediate");
//                hvqCall();
//            } else {
//                hvq.addFirst(U);
//            }
//
//
//        }
//    }
//
//    /*har 1 minute ke baad call krna h*/
//    public void hvqexpire() {
//        System.out.println("running hvqexpire");
//        if (hvq.size() == 0)
//            return;
//        else {
//            User m = hvq.getLast();
//            long diff = (date.getTime() - m.intime);
//            long diffMinutes = (diff / (60 * 1000)) % 60;
//            if (diffMinutes >= 5) {
//                hvq.removeLast();
//                rtoq1.addFirst(m);
//
//                m.intime = date.getTime();
//                hvqexpire();
//            } else
//                return;
//
//
//        }
//    }
//
//    /*this function will be called parallely in har 1 second*/
//    public void rtoq1Call() {
//        System.out.println("running rtoq1Call");
//        if (rtoq1.size() == 0)
//            return;
//        else {
//            User U = rtoq1.getFirst();
//            rtoq1.removeFirst();
//
//            if (doctorAvailable("immediate")) {
//
//                placeCall(U, "immediate");
//                rtoq1Call();
//            } else if (doctorAvailable("slot")) {
//                placeCall(U, "slot");
//                rtoq1Call();
//            } else if (doctorAvailable("hv")) {
//                placeCall(U, "hv");
//                rtoq1Call();
//            } else {
//                rtoq1.addFirst(U);
//            }
//
//
//        }
//    }
//
//    /*har 1 minute ke baad call krna h*/
//    public void rtoq1expire() {
//        System.out.println("running rtoq1expire");
//        if (rtoq1.size() == 0)
//            return;
//        else {
//            User m = rtoq1.getLast();
//            long diff = (date.getTime() - m.intime);
//            long diffMinutes = (diff / (60 * 1000)) % 60;
//            if (diffMinutes >= 5) {
//                rtoq1.removeLast();
//                rtoq2.addFirst(m);
//                m.inrtoq2 = true;
//                m.intime = date.getTime();
//                rtoq1expire();
//            } else
//                return;
//
//
//        }
//    }
//
//    /*har 1 second ke baad call krna h*/
//    public void rtoq2Call() {
//        System.out.println("running rtoq2Call");
//        if (rtoq2.size() == 0)
//            return;
//        else if (rtoq1.size() == 0) {
//            User U = rtoq2.getFirst();
//            rtoq2.removeFirst();
//
//            if (doctorAvailable("immediate")) {
//
//                placeCall(U, "immediate");
//                rtoq2Call();
//            } else if (doctorAvailable("slot")) {
//                placeCall(U, "slot");
//                rtoq2Call();
//            } else if (doctorAvailable("hv")) {
//                placeCall(U, "hv");
//                rtoq2Call();
//            } else {
//                rtoq2.addFirst(U);
//            }
//        } else
//            return;
//    }
//
//    /*har 1 minute ke baad call krna h*/
//    public void rtoq2expire() {
//        System.out.println("running rtoq2expire");
//        if (rtoq2.size() == 0)
//            return;
//        else {
//            User m = rtoq2.getLast();
//            if (m.inrtoq2 == false) {
//                rtoq2.removeLast();
//                rtoq2expire();
//            } else {
//                long diff = (date.getTime() - m.intime);
//                long diffMinutes = (diff / (60 * 1000)) % 60;
//                if (diffMinutes >= 25) {
//                    rtoq2.removeLast();
//                    System.out.println("User will be given option of link and callBack for 15 mins\n");
//                    wtschedq.addFirst(m);
//                    m.inwtschedq = true;
//                    m.inrtoq2 = false;
//                    m.intime = date.getTime();
//                    rtoq2expire();
//                }
//            }
//
//
//        }
//    }
//
//    /*ye wala function every minute call*/
//    public void wtschedqexpire() {
//        System.out.println("running wtschedexpire");
//        if (wtschedq.size() == 0)
//            return;
//        else {
//            User m = wtschedq.getLast();
//            if (m.inwtschedq == false) {
//                wtschedq.removeLast();
//                wtschedqexpire();
//            } else {
//                long diff = (date.getTime() - m.intime);
//                long diffMinutes = (diff / (60 * 1000)) % 60;
//                if (diffMinutes >= 15) {
//                    wtschedq.removeLast();
//                    System.out.println("we will automatically schedule the user\n");
//                    int hr = firstslotavailable();
//                    scheduleSlot(m, hr);
//                    m.inwtschedq = false;
//
//
//                    wtschedqexpire();
//
//                }
//            }
//        }
//
//    }
//    /*har 3 minute ke bad call krna h*/
//
//    public void schedulecalling() {
//        int currenthr = date.getHours();
//        int currentminute = date.getMinutes();
//        int ns = currentminute / 3;
//        if (scharray[currenthr][ns].UserId != -1) {
//            User U = scharray[currenthr][ns];
//
//            if (doctorAvailable("slot")) {
//
//                placeCall(U, "slot");
//                countUserPerhour[currenthr]--;
//                scharray[currenthr][ns] = dummy;
//
//
//            } else if (doctorAvailable("immediate")) {
//                placeCall(U, "immediate");
//                countUserPerhour[currenthr]--;
//                scharray[currenthr][ns] = dummy;
//            } else if (doctorAvailable("hv")) {
//                placeCall(U, "hv");
//                countUserPerhour[currenthr]--;
//                scharray[currenthr][ns] = dummy;
//            }
//        }
//
//
//    }
//
//
//    /*har ek minute me run*/
//    public void bufferSwitching() {
//        long time = date.getTime();
//        Doctor dummyDoctor = new Doctor(-1, "abc", "buffer");
//        for (int i = 0; i < 10; i++) {
//            if (arr[i].role == "buffer") {
//                int pos = -1;
//                long diff = (time - arr[i].time);
//                long diffMinutes = diff / (60 * 1000);
//                if (diffMinutes >= 5) {
//                    for (int j = 0; j < 10; j++) {
//                        if (arr[j].busy == false && arr[j].noofcall > 8) {
//                            if (arr[j].time < dummyDoctor.time) {
//                                dummyDoctor = arr[j];
//                                pos = j;
//                            }
//                        }
//                    }
//                }
//                //swapping arr[pos] and arr[i]
//                if (pos != -1) {
//                    arr[i].role = arr[pos].role;
//                    arr[pos].noofcall = 0;
//                    arr[i].noofcall = 0;
//                    arr[pos].role = "buffer";
//                    arr[i].time = date.getTime();
//                    arr[pos].time = date.getTime();
//
//                }
//                return;
//
//            }
//
//
//        }
//    }
//    public boolean doctorAvailable(String role)
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
//    }
//    public void placeCall(User U, String role)
//    {
//        System.out.println("place call function working");
//
//        Doctor k=firstDoctor(role);
//        DoctorCall(k,U);
//    }
//    public Doctor firstDoctor(String role)
//    {
//        for(int i=0;i<10;i++)
//        {
//            if(main.arr[i].busy==false&& main.arr[i].role==role)
//                return main.arr[i];
//
//        }
//        return main.arr[0];     //will change it later
//    }
//    public void DoctorCall(Doctor k, User U)
//    {
//        Date date=new Date();
//        k.busy=true;
//        System.out.println(k.id + " is busy");
//        U.callattempt++;
//        call(k,U);
//        System.out.println("write for "+k.id+" and "+U.UserId);
//       String M=sc.next();
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
//    public void wantScheduleSlot(User U)
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
//    public void scheduleSlot(User U, int hr)
//    {
//        addSlot(U,hr);
//    }
//    public void editSlot(User U, int hr)
//    {
//        Vector<Integer> A=showAvailableSlot();
//        System.out.println("pick one slot from available slots\n");
//        String M=sc.next();
//        String[] tokens=M.split(" ");
//
//        int newhr;
//        if(tokens[0]=="nextday")
//        {
//
//            newhr=Integer.parseInt(tokens[1]);
//            newhr=newhr+24;
//            if(tokens[2]=="pm")
//                newhr=newhr+12;
//        }
//        else {
//            newhr=Integer.parseInt(tokens[0]);
//            if(tokens[1]=="pm")
//                newhr=newhr+12;
//        }
//        deleteSlot(U,hr);
//        addSlot(U,newhr);
//    }
//    public void deleteSlot(User U, int hr)
//    {
//        countUserPerhour[hr]--;
//        for(int i=0;i<18;i++)
//        {
//            if(scharray[hr][i].UserId==U.UserId)
//            {
//                User dummyUser=new User("abc","123",9);
//                scharray[hr][i]=dummyUser;
//
//            }
//        }
//    }
//    public void addSlot(User U, int hr)
//    {
//        countUserPerhour[hr]++;
//        for(int i=0;i<18;i++)
//        {
//            if(scharray[hr][i].UserId==-1)
//            {
//
//                scharray[hr][i]=U;
//
//            }
//        }
//    }
//    public Vector<Integer> showAvailableSlot(){
//        int currenthr=date.getHours();
//        Vector<Integer> v=new Vector<Integer>();
//        for(int i=currenthr;i<22;i++)
//        {
//            if(countUserPerhour[i]<18)
//            {
//
//
//                if(i>12)
//                {   int j=i-12;
//                    System.out.println(j+"pm - "+(j+1)+" pm\n");
//                }
//                else if(i==12)
//                {
//                    System.out.println(i+"noon - "+(i+1)+" pm\n");
//                }
//                else if(i==11)
//                {
//                    System.out.println(i+"am - "+(i+1)+" noon\n");
//                }
//                else
//                {
//                    System.out.println(i+"am - "+(i+1)+" am\n");
//                }
//                v.add(i);
//            }
//        }
//        for(int i=32;i<48;i++)
//        {   System.out.println("next day ");
//
//            if(countUserPerhour[i]<18)
//            {
//
//                i=i-24;
//                if(i>12)
//                {   int j=i-12;
//                    System.out.println(j+"pm - "+(j+1)+" pm\n");
//                }
//                else if(i==12)
//                {
//                    System.out.println(i+"noon - "+(i+1)+" pm\n");
//                }
//                else if(i==11)
//                {
//                    System.out.println(i+"am - "+(i+1)+" noon\n");
//                }
//                else
//                {
//                    System.out.println(i+"am - "+(i+1)+" am\n");
//                }
//                i=i-24;
//                v.add(i);
//            }
//
//        }
//
//        return v;
//    }
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
//    public void call(Doctor k, User U)     //takes apporx 3 minute
//    {
//        System.out.println(k.id+" calls "+U.name+" having userid "+U.UserId+"\n");
//        //return "Unanswer";
//        //return "answer,unresolved,calldrop";
//        //return "answer,unresolved,callbusy";
//        //return "answer,resolved";
//
//
//    }
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
//    }
//}
