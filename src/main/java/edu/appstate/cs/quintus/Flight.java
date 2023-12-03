package edu.appstate.cs.quintus;

public class Flight 
{
    private String startDate;
    private String returnDate;
    private String dAirline;
    private double cost;
    private String url;
    private String rAirline;

    public Flight()
    {
        startDate = "";
        returnDate = "";
        dAirline = "";
        cost = 0.0;
    }

    public Flight(double cost)
    {
        setCost(cost);
    }

    public Flight(String startDate, String returnDate, String dAirline, double cost)
    {
        setStartDate(startDate);
        setReturnDate(returnDate);
        setDAirline(dAirline);
        setCost(cost);
    }
    
    public Flight(String startDate, String returnDate, String dAirline, double cost, String url)
    {
        setStartDate(startDate);
        setReturnDate(returnDate);
        setDAirline(dAirline);
        setCost(cost);
        setUrl(url);
    }

    public Flight(String startDate, String dAirline, double cost, String url)
    {
        setStartDate(startDate);
        setDAirline(dAirline);
        setCost(cost);
        setUrl(url);
    }

    public Flight(String startDate, String returnDate, String dAirline, double cost, String url, String rAirline)
    {
        setStartDate(startDate);
        setReturnDate(returnDate);
        setDAirline(dAirline);
        setRAirline(rAirline);
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

    public void setDAirline(String dAirline)
    {
        this.dAirline = dAirline;
    }

    public void setRAirline(String rAirline)
    {
        this.rAirline = rAirline;
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

    public String getDAirline()
    {
        return this.dAirline;
    }

    public String getRAirline()
    {
        return this.rAirline;
    }

    public double getCost()
    {
        return this.cost;
    }

    public String getUrl()
    {
        return "https://www.kayak.com" + url;
    }

    public String toString()
    {
        if(getReturnDate() == null)
        {
            return String.format("Departure Date %s | Airline: %s\nReturn Date None | Airline: None\nCost: $%.2f",
                getStartDate(), getDAirline(), getCost(), getUrl());
        }
        return String.format("Departure Date %s | Airline: %s\nReturn Date %s | Airline: %s\nCost: $%.2f",
            getStartDate(), getDAirline(), getReturnDate(), getRAirline(), getCost(), getUrl());
    }
}
