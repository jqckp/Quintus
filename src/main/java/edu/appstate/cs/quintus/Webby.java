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
    
    private String startLocation;
    private String endLocation;
    private String startDate;
    private String endDate;

    public static void main(String[] args) {
        Webby webby = new Webby("RDU", "DEL", "2023-12-17", "2023-12-24");
        webby.webbyGo();
    }
    
    public Webby(String startLocation, String endLocation, String startDate, String endDate)
    {
        setStartLocation(startLocation);
        setEndLocation(endLocation);
        setStartDate(startDate);
        setEndDate(endDate);
        
    }

    public void webbyGo()
    {
        String url = "https://www.kayak.com/flights/" + getStartLocation() + "-" 
                    + getEndLocation() + "/" + getStartDate() + "/" + getEndDate()  + "?sort=price_a";
        System.out.println(url);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //WebElement pbutton = driver.findElement(By.className("ytp-play-button"));
        //pbutton.click();
        try 
        {
            Thread.sleep(30000);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        //driver.get(url);
        try 
        {
            Thread.sleep(10000);
        } 
        catch (InterruptedException e) 
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
            }    
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
        
        List<WebElement> flights = driver.findElements(By.className("nrc6-wrapper"));
        int count = 0;
        for(WebElement webE: flights)
        {
            //System.out.println(webE);
            count++;
            String outerHTML = webE.getAttribute("outerHTML");
            Document doc = Jsoup.parse(outerHTML);
            Elements price = doc.getElementsByClass("f8F1-price-text");
            Elements airline = doc.getElementsByClass("J0g6-labels-grp");
            System.out.println(airline.text());
            System.out.println(price.text());
        }
        
        System.out.println(count);;
        driver.quit();
    }

    public String getStartLocation()
    {
        return this.startLocation;
    }

    public String getEndLocation()
    {
        return this.endLocation;
    }

    public String getStartDate()
    {
        return this.startDate;
    }

    public String getEndDate()
    {
        return this.endDate;
    }
    
    public void setStartLocation(String startLocation)
    {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation)
    {
        this.endLocation = endLocation;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    //private String urll = "https://youtu.be/dQw4w9WgXcQ?si=HWGsV2IEMpB-dLhQ";
}

