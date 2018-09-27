/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Calendar;

/**
 *
 * @author shara
 */
public class NewClass {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Original = " + calendar.getTime());

        // Substract 2 hour from the current time
        calendar.add(Calendar.HOUR, -2);

        // Add 30 minutes to the calendar time
        calendar.add(Calendar.MINUTE, 30);

        // Add 300 seconds to the calendar time
        calendar.add(Calendar.SECOND, 300);
        System.out.println("Updated  = " + calendar.getTime());
    }

}
