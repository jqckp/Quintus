package edu.appstate.cs.quintus;

import java.util.Calendar;

public class DateOBJ 
{
    public static void main(String[] args) 
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 1, 28);
        int dateToAdd = 1;
        int year = calendar.get(Calendar.YEAR);
        calendar.add(Calendar.DAY_OF_MONTH, dateToAdd);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        
        
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
        
    }
}
