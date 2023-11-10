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

    
    public Input() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter start date ('mm/dd/yyyy'):");
        setStartDate(scan.nextLine());
        System.out.print("Enter end date ('mm/dd/yyyy'):");
        setEndDate(scan.nextLine());
        System.out.print("Enter in your max price limit:");
        setCost(scan.nextLine());

        scan.close();            
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



}

