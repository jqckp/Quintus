package edu.appstate.cs.quintus;

import java.io.FileWriter;
import java.util.Scanner;



/**
 * Reads user input 
 * 
 * @author Oscar Silva, Jack Porter
 * @version 11/2/2023
 *
 */

public class UserInput {

    private String startDate;
    private String endDate;

    
    public UserInput()
    {

    }


    public readFlightRange(Scanner dateReader)
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
