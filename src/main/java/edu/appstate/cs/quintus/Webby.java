package edu.appstate.cs.quintus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Webby 
{
    
    private static String startLocation = "RDU";
    private static String endLocation = "DEL";
    private static String startDate = "2023-12-17";
    private static String endDate = "2023-12-24";
    public static void main(String[] args)
    {

        String url = "https://www.kayak.com/flights/" + startLocation + "-" + endLocation + "/" + startDate + "/" + endDate  + "?sort=bestflight_a";
        System.out.println(url);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/");     
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
