package edu.appstate.cs.quintus;

import java.util.Scanner;



/**
 * Reads user input 
 * 
 * @author Oscar Silva, Jack Porter
 * @version 11/2/2023
 *
 */

public class Input 
{

    private String startDate;
    private String endDate;
    private String cost;
    private String startLocation;
    private String endLocation;

    
    public Input() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Start Location:");
        setStartLocation(scan.nextLine());
        System.out.print("End Location:");
        setEndLocation(scan.nextLine());
        System.out.print("Enter start date:");
        setStartDate(scan.nextLine());
        System.out.print("Enter end date:");
        setEndDate(scan.nextLine());
        System.out.print("Enter in your max price limit:");
        setCost(scan.nextLine());

        scan.close();            
    }

    public String getStartLocation()
    {
        return startLocation;
    }

    public String getEndLocation()
    {
        return endLocation;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getCost()
    {
        return cost;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }
    public void setCost(String cost)
    {
        this.cost = cost;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public void setStartLocation(String startLocation)
    {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation)
    {
        this.endLocation = endLocation;
    }



}

