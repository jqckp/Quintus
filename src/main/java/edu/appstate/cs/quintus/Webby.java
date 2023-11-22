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
        driver.get(url);
        try 
        {
            Thread.sleep(10000);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        WebElement button = driver.findElement(By.className("bBPb-close"));
        button.click();
        try 
        {
            Thread.sleep(10000);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        
        driver.close();
        driver.quit();
        
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
