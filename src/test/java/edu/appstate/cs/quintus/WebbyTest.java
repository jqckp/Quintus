package edu.appstate.cs.quintus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebbyTest 
{
    @Test
    public void testOneAirportWhileLoop()
    {
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Input input = new Input();
        Webby webby;
        WebDriver driver = new ChromeDriver();

        int duration = 0;

        Calendar earliest = Calendar.getInstance();
        earliest.add(Calendar.DAY_OF_MONTH, 10);
        Calendar lateist = Calendar.getInstance();
        lateist.add(Calendar.DAY_OF_MONTH, 12);

        String date;
        int year;
        int month;
        int day;

        int count = 0;
        if (duration == 0)
        {
            while(earliest.compareTo(lateist) <= 0)
            {
                year = earliest.get(Calendar.YEAR);
                month = earliest.get(Calendar.MONTH) + 1;
                day = earliest.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;

                input.setInput(date, "CLT", "LAX");
                
                webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
                webby.webbyOneAirline(flights, driver);

                earliest.add(Calendar.DAY_OF_MONTH, 1);

                count++;

            }
            driver.quit();
        }
        else
        {
            System.out.println("duration wasn't zero");
        }

        assertEquals(3, count, "While loop did not run the expected amount for a one way trip");
    }

    @Test
    public void testTwoAirportWhileLoop()
    {
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Input input = new Input();
        Webby webby;
        WebDriver driver = new ChromeDriver();

        int duration = 1;

        Calendar earliest = Calendar.getInstance();
        earliest.add(Calendar.DAY_OF_MONTH, 10);
        Calendar lateist = Calendar.getInstance();
        lateist.add(Calendar.DAY_OF_MONTH, 12);
        Calendar durAdd = Calendar.getInstance();
        durAdd.set(earliest.get(Calendar.YEAR), earliest.get(Calendar.MONTH), earliest.get(Calendar.DAY_OF_MONTH));
        durAdd.add(Calendar.DAY_OF_MONTH, duration);

        String date;
        int year;
        int month;
        int day;

        int count = 0;
        if (duration != 0)
        {
            while(durAdd.compareTo(lateist) <= 0)
            {
                year = earliest.get(Calendar.YEAR);
                month = earliest.get(Calendar.MONTH) + 1;
                day = earliest.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;

                int year2 = durAdd.get(Calendar.YEAR);
                int month2 = durAdd.get(Calendar.MONTH) + 1;
                int day2 = durAdd.get(Calendar.DAY_OF_MONTH);
                String date2 = year2 + "-" + month2 + "-" + day2;

                input.setInput(date, date2, "CLT", "LAX");
                
                webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
                webby.webbyTwoAirline(flights, driver);

                earliest.add(Calendar.DAY_OF_MONTH, 1);
                durAdd.add(Calendar.DAY_OF_MONTH, 1);

                count++;

            }
            driver.quit();
        }
        else
        {
            System.out.println("duration wasn't zero");
        }

        assertEquals(2, count, "While loop did not run the expected amount for a round trip of 1 day");
    }

}
