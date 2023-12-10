package edu.appstate.cs.quintus;

import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Webby 
{
    
    private String startLocation;
    private String endLocation;
    private String startDate;
    private String endDate;

    /**
     * Contructor with parameter aguments 
     * 
     * @param startLocation Loction of the depature of the flight
     * @param endLocation Loction of the depature of the flight
     * @param startDate Departure date of flight 
     * @param endDate Return Date of flight
     */
    public Webby(String startLocation, String endLocation, String startDate, String endDate)
    {
        setStartLocation(startLocation);
        setEndLocation(endLocation);
        setStartDate(startDate);
        setEndDate(endDate);
        
    }

    /**
    * Method for scraping flight data for a one way trip 
    *
    * @param flights The linked list that flight objest will be added to
    * @param driver The ChromeDriver that will be used to access the url for webscarping
    */ 
    public void webbyOneAirline(LinkedList<Flight> flights, WebDriver driver)
    {
        String url = "https://www.kayak.com/flights/" + getStartLocation() + "-" 
                    + getEndLocation() + "/" + getStartDate() + "?sort=price_a";
        System.out.println(url);
        
        driver.get(url);

        try 
        {
            Thread.sleep(7000);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        try
        {
        List<WebElement> webFlights = driver.findElements(By.className("nrc6-wrapper"));
       
        for(WebElement webE: webFlights)
        {
            String outerHTML = webE.getAttribute("outerHTML");
            Document doc = Jsoup.parse(outerHTML);
            Elements ePrice = doc.getElementsByClass("f8F1-price-text");
            Elements eAirline = doc.getElementsByClass("c_cgF");
            Elements eUrl = doc.getElementsByTag("a");String $price = ePrice.get(0).text();
            StringBuilder price = new StringBuilder($price);
            price.deleteCharAt(0);
            if (price.length() > 3)
            {
                price.deleteCharAt(1);
            }
            String flightUrl = eUrl.attr("href");
            if(!(flightUrl.charAt(0) == '/'))
            {
                flightUrl = "/flights/" + getStartLocation() + "-" 
                            + getEndLocation() + "/" + getStartDate() + "?sort=price_a";
            }
            flights.add(new Flight(getStartDate(), eAirline.get(0).text(), 
                        Double.parseDouble(price.toString()), flightUrl));
        }
        }
        catch (Exception e)
        {
            System.out.println("Element not found");
        }
    }

    /**
    * Method for scraping flight data with a return date
    *
    * @param flights The linked list that flight objest will be added to
    * @param driver The ChromeDriver that will be used to access the url for webscarping
    */   
    public void webbyTwoAirline(LinkedList<Flight> flights, WebDriver driver)
    {
        String url = "https://www.kayak.com/flights/" + getStartLocation() + "-" 
                    + getEndLocation() + "/" + getStartDate() + "/" + getEndDate()  + "?sort=price_a";
        System.out.println(url);

        driver.get(url);

        try 
        {
            Thread.sleep(5000);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        try
        {
        List<WebElement> webFlights = driver.findElements(By.className("nrc6-wrapper"));
       
        for(WebElement webE: webFlights)
        {
            String outerHTML = webE.getAttribute("outerHTML");
            Document doc = Jsoup.parse(outerHTML);
            Elements ePrice = doc.getElementsByClass("f8F1-price-text");
            Elements eAirline = doc.getElementsByClass("c_cgF");
            Elements eUrl = doc.getElementsByTag("a");String $price = ePrice.get(0).text();
            StringBuilder price = new StringBuilder($price);
            price.deleteCharAt(0);
            if (price.length() > 3)
            {
                price.deleteCharAt(1);
            }
            String flightUrl = eUrl.attr("href");
            if(!(flightUrl.charAt(0) == '/'))
            {
                flightUrl = "/flights/" + getStartLocation() + "-" 
                            + getEndLocation() + "/" + getStartDate() + "/" + getEndDate()  + "?sort=price_a";
            }
            flights.add(new Flight(getStartDate(), getEndDate(), eAirline.get(0).text(), 
                        Double.parseDouble(price.toString()), flightUrl, eAirline.get(5).text()));
        }
        }
        catch (Exception e)
        {
            System.out.println("Element not found");
        }
    }

    /**
     * Departure Location Getter
     * 
     * @return
     */
    public String getStartLocation()
    {
        return this.startLocation;
    }

    /**
     * Departure Date Getter
     * 
     * @return
     */
    public String getEndLocation()
    {
        return this.endLocation;
    }

    /**
     * Departure Location Getter
     * 
     * @return
     */
    public String getStartDate()
    {
        return this.startDate;
    }

    /**
     * Return Date Getter
     * 
     * @return
     */
    public String getEndDate()
    {
        return this.endDate;
    }
    
    /**
     * Deparutre Location Setter 
     * 
     * @param startLocation Departure Location
     */
    public void setStartLocation(String startLocation)
    {
        this.startLocation = startLocation;
    }

    /**
     * Deparutre Location Setter 
     * 
     * @param endLocation Destination Location
     */
    public void setEndLocation(String endLocation)
    {
        this.endLocation = endLocation;
    }

    /**
     * Depaarture Date Setter 
     * 
     * @param endLocation Destination Date
     */
    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    /**
     * Return Date Setter 
     * 
     * @param endLocation Return Date
     */
    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }
}

