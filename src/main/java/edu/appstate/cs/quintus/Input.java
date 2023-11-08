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

    
public Input() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter start date:");
        String start = scan.nextLine();
        setStartDate(start);
        System.out.println("Enter end date:");
        String end = scan.nextLine();
        setEndDate(end);

        scan.close();            
    }


    public void readFlightRange(Scanner dateReader)
    {

    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }



}

