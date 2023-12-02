package edu.appstate.cs.quintus;

import java.util.Calendar;
import java.util.LinkedList;

import org.openqa.selenium.devtools.v117.runtime.model.CallArgument;

import java.awt.Desktop;
import java.net.URI;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application
{
    /**
    * This is the main method
    */   
    public static void main(String[] args) throws Exception
    {
        launch(args);


        
<<<<<<< HEAD
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Input input = new Input();
        //input.setInput("2023-12-14", "10000", "CLT", "NYC");
        Webby webby;
        //webby.webbyOneAirline(flights);

        int duration = 0;

        Calendar earliest = Calendar.getInstance();
        earliest.set(2023, 11, 13);
        Calendar lateist = Calendar.getInstance();
        lateist.set(2023, 11, 24);
        Calendar durAdd = Calendar.getInstance();
        durAdd.set(2023, 11, 13);
        durAdd.add(Calendar.DAY_OF_MONTH, duration);

        String date;
        int year;
        int month;
        int day;

        String date2;
        int year2;
        int month2;
        int day2;

        input.setCost("200");
        if (duration == 0)
        {
            while(earliest.compareTo(lateist) <= 0)
            {
                year = earliest.get(Calendar.YEAR);
                month = earliest.get(Calendar.MONTH) + 1;
                day = earliest.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;

                input.setInput(date, "CLT", "LAX");
                
                webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
                webby.webbyOneAirline(flights);

                earliest.add(Calendar.DAY_OF_MONTH, 1);

            }
            
        Utility.readOneFlights(flights, input);

        }
        else
        {
            while(durAdd.compareTo(lateist) <= 0)
            {
                year = earliest.get(Calendar.YEAR);
                month = earliest.get(Calendar.MONTH) + 1;
                day = earliest.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;

                year2 = durAdd.get(Calendar.YEAR);
                month2 = durAdd.get(Calendar.MONTH) + 1;
                day2 = durAdd.get(Calendar.DAY_OF_MONTH);
                date2 = year2 + "-" + month2 + "-" + day2;

                input.setInput(date, date2, "CLT", "LAX");

                webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
                webby.webbyTwoAirline(flights);

                earliest.add(Calendar.DAY_OF_MONTH, 1);
                durAdd.add(Calendar.DAY_OF_MONTH, 1);
            }

            Utility.readTwoFlights(flights,input);
        }
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(flights.get(0).getUrl()));
=======
        //LinkedList<Flight> flights = new LinkedList<Flight>();
        //Input input = new Input();
        //input.setInput("2023-12-14", "10000", "CLT", "NYC");
        //Webby webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
        //webby.webbyOneAirline(flights);
        //Utility.readOneFlights(flights, input);
        //Desktop desktop = Desktop.getDesktop();
        //desktop.browse(new URI(flights.get(0).getUrl()));
>>>>>>> 20529925aaf041a25524cbee2b3b909d53ce3a68
    }

    @SuppressWarnings("unused")
    @Override
    public void start(Stage stage) throws Exception 
    {
        UI userInterface = new UI(stage);

    }
}