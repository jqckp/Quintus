package edu.appstate.cs.quintus;
import java.util.LinkedList;

public class Flight 
{
    private String startDate;
    private String returnDate;
    private String airline;
    private double cost;
    private String url;
    private LinkedList<Flight> flightList;

    public Flight()
    {
        startDate = "";
        returnDate = "";
        airline = "";
        cost = 0.0;
    }

    public Flight(double cost)
    {
        setCost(cost);
    }

    public Flight(String startDate, String returnDate, String airline, double cost)
    {
        setStartDate(startDate);
        setReturnDate(returnDate);
        setAirline(airline);
        setCost(cost);
    }
    
    public Flight(String startDate, String returnDate, String airline, double cost, String url)
    {
        setStartDate(startDate);
        setReturnDate(returnDate);
        setAirline(airline);
        setCost(cost);
        setUrl(url);
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
    

    public void setReturnDate(String returnDate)
    {
        this.returnDate = returnDate;
    }

    public void setAirline(String airline)
    {
        this.airline = airline;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public String getStartDate()
    {
        return this.startDate;
    }

    public String getReturnDate()
    {
        return this.returnDate;
    }

    public String getAirline()
    {
        return this.airline;
    }

    public double getCost()
    {
        return this.cost;
    }

    public String getUrl()
    {
        return url;
    }

    public String toString()
    {
        return String.format("Cost: %.2f | Departure Date: %s | Return Date: %s | Airline: %s",
            getCost(), getStartDate(), getReturnDate(), getAirline());
    }
}
