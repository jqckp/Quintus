package edu.appstate.cs.quintus;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import org.junit.jupiter.api.Test;

public class FlightTest 
{
    @Test
    public void flightConstructor()
    {
        Calendar earliest = Calendar.getInstance();
        earliest.add(Calendar.DAY_OF_MONTH, 10);
        Calendar lateist = Calendar.getInstance();
        lateist.add(Calendar.DAY_OF_MONTH, 12);

        int year = earliest.get(Calendar.YEAR);
        int month = earliest.get(Calendar.MONTH) + 1;
        int day = earliest.get(Calendar.DAY_OF_MONTH);
        
        int year2 = lateist.get(Calendar.YEAR);
        int month2 = lateist.get(Calendar.MONTH) + 1;
        int day2 = lateist.get(Calendar.DAY_OF_MONTH);

        String startdate = year + "-" + month + "-" + day;
        String returndate = year2 + "-" + month2 + "-" + day2;

        Flight flight = new Flight(startdate, returndate, "RDU", 10000, "url", "DEL");

        assertEquals(flight.getStartDate(), startdate, "Starting date does not match");
        assertEquals(flight.getReturnDate(), returndate,"Return date does not match");
        assertEquals(flight.getDAirline(), "RDU", "Start Location does not match");
        assertEquals(flight.getRAirline(), "DEL", "Return Locations does not match");
        assertEquals(flight.getCost(), 10000, "Cost does not match");
        assertEquals(flight.getUrl(), "https://www.kayak.comurl", "url did not match");

    }
}
