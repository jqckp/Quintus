package edu.appstate.cs.quintus;

import java.util.LinkedList;
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

    
    public Webby(String startLocation, String endLocation, String startDate, String endDate)
    {
        setStartLocation(startLocation);
        setEndLocation(endLocation);
        setStartDate(startDate);
        setEndDate(endDate);
        
    }

    public void webbyGo(LinkedList<Flight> flights)
    {
        String url = "https://www.kayak.com/flights/" + getStartLocation() + "-" 
                    + getEndLocation() + "/" + getStartDate() + "/" + getEndDate()  + "?sort=price_a";
        System.out.println(url);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
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
        
        List<WebElement> webFlights = driver.findElements(By.className("nrc6-wrapper"));
       
        for(WebElement webE: webFlights)
        {
            //System.out.println(webE);
            String outerHTML = webE.getAttribute("outerHTML");
            Document doc = Jsoup.parse(outerHTML);
            Elements ePrice = doc.getElementsByClass("f8F1-price-text");
            Elements eAirline = doc.getElementsByClass("J0g6-labels-grp");
            String $price = ePrice.text();
            StringBuilder price = new StringBuilder($price);
            price.deleteCharAt(0);
            price.deleteCharAt(1);
            flights.add(new Flight(getStartDate(), getEndDate(), eAirline.text(), Double.parseDouble(price.toString())));
        }
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
}

