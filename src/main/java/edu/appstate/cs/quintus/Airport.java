package edu.appstate.cs.quintus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Airport 
{
    public static void main(String[] args) 
    {
        //Airport airport = new Airport();
        //airport.airportGo();

        int i = 0;
        String loc = "Boulder, CO";

        for(AirportCode c: AirportCode.values()) 
        {
            if(loc == c.getLocation())
            {
                System.out.println(c.getCode());
                i++;
            }            
        }
        if(i == 0)
        {
            System.out.println("There wasn't any city named like what you typed in...sorry uwu");
        }
    }

    /**
     * Created and used this methods to make a list of airport locations and their corresponding codes
     * in the airport_codes.txt file. Did this to create an enum class. If you want to change airport_codes.txt again,
     * then you need to change the pathname and delete what as ever in airport_codes.txt in the first place.
     */
    public void airportGo()
    {
        String url = "https://www.ccra.com/airport-codes/";

        try
        {
            File file = new File("C:\\Users\\dsagi\\ditto-fall-2023\\airport_codes.txt");
            PrintWriter pw = new PrintWriter(file);

            WebDriver driver = new ChromeDriver();
            driver.get(url);
        
            try 
            {
                Thread.sleep(3500);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            WebElement button = driver.findElement(By.className("cli_settings_button"));
            button.click();
            try 
            {
                Thread.sleep(2250);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            button = driver.findElement(By.id("wt-cli-privacy-save-btn"));
            button.click();
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
  
            for(int i = 0; i < 32; i++)
            {
                // Locate the table containing airport information
                WebElement table = driver.findElement(By.id("tablepress-40"));

                // Find all rows within the table
                List<WebElement> rows = table.findElements(By.tagName("tr"));

                for (WebElement row : rows) 
                {
                    // Extract city and code from each row
                    List<WebElement> columns = row.findElements(By.tagName("td"));
                    if (columns.size() >= 3) 
                    {
                        String city = columns.get(0).getText().trim();
                        String nCity = city.replaceAll("[,\\s]+", "_").replaceAll("\\.", "")
                            .replaceAll("'", "").replaceAll("-", "_");
                        String country = columns.get(1).getText().trim();
                        String code = columns.get(2).getText().trim();
                        pw.println(nCity + "(" + '"' + code + '"' + ", " + '"' + country + '"' + ", " + '"' + city + '"' + "), ");
                    }
                }
                button = driver.findElement(By.id("tablepress-40_next"));
                button.click();
                try 
                {
                    Thread.sleep(750);
                }    
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }

            pw.close();
            driver.quit();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } 
    }
}
