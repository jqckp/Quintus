package edu.appstate.cs.quintus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import java.util.*;


public class Webby 
{
    
    public static String startLocation = "RDU";
    public static String endLocation = "DEL";
    public static String startDate = "2023-12-17";
    public static String endDate = "2023-12-24";
    public static void main(String[] args)
    {
        String url = "https://www.kayak.com/flights/" + startLocation + "-" + endLocation + "/" + startDate + "/" + endDate  + "?sort=price_a";
        WebDriver driver = new ChromeDriver();
        driver.get(url);     
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

    public String getEndDate()
    {
        return endDate;
    }
    
}
