package com.flipkart;

/*import main.java.flipkart.restController.AdminRestAPI;
import main.java.flipkart.restController.ProfessorRestAPI;
import main.java.flipkart.restController.StudentRestAPI;*/

import com.flipkart.service.*;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Scanner;

import static com.flipkart.service.DB.*;

/**
 * Hello world!
 *Application config is a dropwizard config class which contains the initialized and run method in which we need to register all the restful controller
 * inside a jersey container which is running inside the dropwizard container
 */
public class App extends Application<Configuration> {

    public static Doctor[] arr;
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
//        e.jersey().register(new AdminRestAPI());
        e.jersey().register(new DoctorRestAPI());
        e.jersey().register(new UserRestAPI());
//        e.jersey().register(new StudentRestAPI());



    }

    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);

        Date date=new Date();
        System.out.println(date);

        for(int i=0;i<=3;i++)
        {
            User U=new User("a"+i,"123"+i,i/5*1000+45);


            System.out.println("your order is processing"+U.UserId);
            date=new Date();
            int hr= date.getHours();
            if(i==10)
            {
                DB.orderDetails.put(U.UserId,"");
                DB.updateMessage(U.UserId," order_id "+U.UserId+" has been placed ");
                threadClass.addSlot(U,hr);

            }
            else {
                if(hr<8||hr>=22)      //will change it later to hr>22||hr<8
                {
                    // System.out.println("User will be given option of link for 15 mins\n");
                    U.inwtschedq=true;
                    DB.wtschedq.addFirst(U);
                }
                else {
                    if (U.price > 1000) {
                        DB.orderDetails.put(U.UserId,"");
                        DB.updateMessage(U.UserId," order_id "+U.UserId+" has been placed ");
                        DB.hvq.addFirst(U);

                    } else {
                        DB.orderDetails.put(U.UserId,"");
                        DB.updateMessage(U.UserId," order_id "+U.UserId+" has been placed ");
                        DB.rtoq1.addFirst(U);
                    }
                }
            }
        }



        System.out.println("HELLO from APP");

        for(int i=0;i<48;i++)
        {
            for(int j=0;j<20;j++)
            {
                scharray[i][j]=dummyUser;
            }
        }


        arr = new Doctor[5];
        System.out.println("hii friends");

        arr[0] = new Doctor(1, "doctor1_immediate", "immediate");
        DB.doctorDetails.put(arr[0].id,"");
        updatedoctorMessage(arr[0].id,"doctor "+arr[0].name+ " marked available in the system");
        arr[1] = new Doctor(2, "doctor2_immediate", "immediate");
        DB.doctorDetails.put(arr[1].id,"");
        updatedoctorMessage(arr[1].id,"doctor "+arr[1].name+ " marked available in the system");
        arr[2] = new Doctor(3, "doctor3_hv", "hv");
        DB.doctorDetails.put(arr[2].id,"");
        updatedoctorMessage(arr[2].id,"doctor "+arr[2].name+ " marked available in the system");
        arr[3] = new Doctor(4, "doctor4_slot", "slot");
        DB.doctorDetails.put(arr[3].id,"");
        updatedoctorMessage(arr[3].id,"doctor "+arr[3].name+ " marked available in the system");
        arr[4] = new Doctor(5, "doctor5_buffer", "buffer");
        DB.doctorDetails.put(arr[4].id,"");
        updatedoctorMessage(arr[4].id,"doctor "+arr[4].name+ " marked available in the system");

        threadClass obj=new threadClass();
//        obj.t1.start();
        obj.t2.start();
        obj.t3.start();
        threadClass.t5.start();
//        obj.t1.join();
//        obj.t2.join();
//        obj.t3.join();
//        obj.t5.join();


        new App().run(args);
    }
}