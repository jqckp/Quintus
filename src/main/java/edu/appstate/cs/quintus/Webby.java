package edu.appstate.cs.quintus;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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

        String url = "https://www.kayak.com/flights/" + startLocation + "-" 
                    + endLocation + "/" + startDate + "/" + endDate  + "?sort=bestflight_a";
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
        
        for(int i = 0; i < 5; i++)
        {
            button = driver.findElement(By.className("show-more-button"));
            button.click();
            try 
            {
                Thread.sleep(3000);
            }    catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
        
        List<WebElement> flights = driver.findElements(By.className("nrc6-wrapper"));
        for(WebElement webE: flights)
        {
            //System.out.println(webE);
            String outerHTML = webE.getAttribute("outerHTML");
            Document doc = Jsoup.parse(outerHTML);
            Elements price = doc.getElementsByClass("f8F1-price-text");
            Elements airline = doc.getElementsByClass("J0g6-labels-grp");
            System.out.println(airline.text());
            System.out.println(price.text());
        }
        
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

