package edu.appstate.cs.quintus;

public class Flight 
{
    private String startDate;
    private String returnDate;
    private String dAirline;
    private double cost;
    private String url;
    private String rAirline;

    /**
     * no-args constructor
     * 
     */
    public Flight()
    {
        startDate = "";
        returnDate = "";
        dAirline = "";
        cost = 0.0;
    }

    /**
     * Constructor setting cost field only 
     * 
     * @param cost cost of the flight
     */
    public Flight(double cost)
    {
        setCost(cost);
    }

    /**
     * Constructor setting all fields, except url
     * 
     * @param startDate 
     * @param returnDate
     * @param dAirline
     * @param cost
     */
    public Flight(String startDate, String returnDate, String dAirline, double cost)
    {
        setStartDate(startDate);
        setReturnDate(returnDate);
        setDAirline(dAirline);
        setCost(cost);
    }
    
    /**
     * 
     * @param startDate
     * @param returnDate
     * @param dAirline
     * @param cost
     * @param url
     */
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

    /**
     * ToSting method
     * 
     * @return data of flight in string format
     */
    public String toString()
    {
        if(getReturnDate() == null)
        {
            return String.format("Depart Date %s | Airline: %s\nReturn Date None | Airline: None\nCost: $%.2f",
                getStartDate(), getDAirline(), getCost(), getUrl());
        }
        return String.format("Depart Date %s | Airline: %s\nReturn Date %s | Airline: %s\nCost: $%.2f",
            getStartDate(), getDAirline(), getReturnDate(), getRAirline(), getCost(), getUrl());
    }
}
