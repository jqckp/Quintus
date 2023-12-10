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

        assertEquals(3, count, "While loop did not run the expected amount");
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

        assertEquals(2, count, "While loop did not run the expected amount");
    }

}
