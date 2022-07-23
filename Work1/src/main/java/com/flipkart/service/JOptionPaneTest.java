package com.flipkart.service;



import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class JOptionPaneTest {
    public static String takinginput(User U)
    {
        String[] items = {"schedule my call", "callback request", "ignore"};
        JComboBox combo = new JComboBox(items);
        //JTextField field1 = new JTextField("1234.56");

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("call status"));
        panel.add(combo);

        int result = JOptionPane.showConfirmDialog(null, panel, U.UserId+" pls schedule your call ",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(
                    combo.getSelectedItem());
        } else {
            System.out.println("Cancelled");
        }
        return Objects.requireNonNull(combo.getSelectedItem()).toString();

    }
    public static String askSchedule(User U)
    {
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
        JComboBox combo = new JComboBox(items);
        //JTextField field1 = new JTextField("1234.56");

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("select slot"));
        panel.add(combo);

        int result = JOptionPane.showConfirmDialog(null, panel, "pls select your slot UserId: "+U.UserId,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(
                    combo.getSelectedItem());
        } else {
            System.out.println("Cancelled");
        }
        return Objects.requireNonNull(combo.getSelectedItem()).toString();
    }
    public static String takinginput(int doctorid,int Userid)
    {
        String[] items = {"answerresolved", "answerunresolvedcallbusy", "answerunresolvedcalldrop", "unanswer"};
        JComboBox combo = new JComboBox(items);
        //JTextField field1 = new JTextField("1234.56");

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("call status"));
        panel.add(combo);

        int result = JOptionPane.showConfirmDialog(null, panel, "Call status for "+Userid+" and Doctor: "+doctorid,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(
                     combo.getSelectedItem());
        } else {
            System.out.println("Cancelled");
        }
        return Objects.requireNonNull(combo.getSelectedItem()).toString();

    }

    public static void takinginput() throws IOException {

        JTextField name = new JTextField("Makhan");
        JTextField id= new JTextField("");
        JTextField number = new JTextField("1234567890");
        JTextField price= new JTextField("1234");
        JPanel panel = new JPanel(new GridLayout(1, 1));

        panel.add(new JLabel("name:"));
        panel.add(name);
        panel.add(new JLabel("User id:"));
        panel.add(id);
        panel.add(new JLabel("number:"));
        panel.add(number);
        panel.add(new JLabel("price:"));
        panel.add(price);



        int result = JOptionPane.showConfirmDialog(null, panel, "PlaceOrder",
                JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);

        User U=new User(name.getText(),number.getText(),parseInt(price.getText()));

        System.out.println("your order is processing"+U.UserId);
        DB.orderDetails.put(U.UserId,"");
        DB.updateMessage(U.UserId," order_id "+U.UserId+" has been placed ");
        int hr= threadClass.date.getHours();

        if(hr<8||hr>22)      //will change it later to hr>22||hr<8
        {
            // System.out.println("User will be given option of link for 15 mins\n");
            U.inwtschedq=true;
            DB.wtschedq.addFirst(U);
        }
        else {
            if (U.price > 1000) {
                DB.hvq.addFirst(U);
            } else {
                DB.rtoq1.addFirst(U);
            }
        }

    }

    public static void main(String[] args) {
        //takinginput();
    }
}
