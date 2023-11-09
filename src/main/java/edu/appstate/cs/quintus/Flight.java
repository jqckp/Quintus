package edu.appstate.cs.quintus;

public class Flight 
{
    private String startDate;
    private String returnDate;
    private String airline;
    private double cost;

    public Flight()
    {
        startDate = "";
        returnDate = "";
        airline = "";
        cost = 0.0;
    }

    public Flight(String startDate, String returnDate, String airline, double cost)
    {
        setStartDate(startDate);
        setReturnDate(returnDate);
        setAirline(airline);
        setCost(cost);
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
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

    public String getReturnData()
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

    public String toString()
    {
        String str = "$" + getCost() + " " + getAirline() + " " + getStartDate() + " " + getReturnData();
        return str;
    }
}
