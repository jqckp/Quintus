package edu.appstate.cs.quintus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class AppTest
{
    //@Test
    //public void testSum() 
    //{
        //assertEquals(3, App.sum(1,2), "1 + 2 should be 3");
    //}

    @Test
    public void testLowerMethod()
    {
        assertEquals(2.0, Utility.lower(2.0,4.0), "2.0 is lower than 4.0");
        assertEquals(2.0, Utility.lower(4.0,2.0), "4.0 is higher than 2.0");
    }

    @Test
    public void testUtilityMergeSort()
    {
        LinkedList<Flight> flights = new LinkedList<>();
        flights.add(new Flight("Flight1", "Start1", "End1", 500.0));
        flights.add(new Flight("Flight2", "Start2", "End2", 300.0));
        flights.add(new Flight("Flight3", "Start3", "End3", 700.0));
        flights.add(new Flight("Flight4", "Start4", "End4", 400.0));

        Utility.mergeSortFlights(flights);

        assertEquals(300.0, flights.get(0).getCost(), "First node is out of order");
        assertEquals(400.0, flights.get(1).getCost(), "Second node is out of order");
        assertEquals(500.0, flights.get(2).getCost(), "Third node is out of order");
        assertEquals(700.0, flights.get(3).getCost(), "Fourth node is out of order");
    }

    @Test
    public void testOneAirportWhileLoop()
    {
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Input input = new Input();
        Webby webby;

        int duration = 0;

        Calendar earliest = Calendar.getInstance();
        earliest.add(Calendar.DAY_OF_MONTH, 10);
        Calendar lateist = Calendar.getInstance();
        lateist.add(Calendar.DAY_OF_MONTH, 14);

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
                webby.webbyOneAirline(flights);

                earliest.add(Calendar.DAY_OF_MONTH, 1);

                count++;

            }

        }
        else
        {
            System.out.println("duration wasn't zero");
        }

        assertEquals(5, count, "While loop did not run the expected amount");
    }

}
