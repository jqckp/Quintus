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


        
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Input input = new Input();
        input.setInput("2023-12-14", "10000", "CLT", "NYC");
        Webby webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
        //webby.webbyOneAirline(flights);

        int duration = 0;

        Calendar earliest = Calendar.getInstance();
        earliest.set(2023, 11, 13);
        Calendar lateist = Calendar.getInstance();
        lateist.set(2023, 11, 24);
        Calendar durAdd = Calendar.getInstance();

        String date;
        int year;
        int month;
        int day;


        earliest.add(Calendar.DAY_OF_MONTH, duration);
        if (duration == 0)
        {
            year = earliest.get(Calendar.YEAR);
            month = earliest.get(Calendar.MONTH);
            day = earliest.get(Calendar.DAY_OF_MONTH);
            webby.webbyOneAirline(flights);
            earliest.add(Calendar.DAY_OF_MONTH, 1);
            input.setInput(STYLESHEET_CASPIAN, STYLESHEET_CASPIAN, STYLESHEET_MODENA, STYLESHEET_CASPIAN);

        }
        else
        {
            webby.webbyTwoAirline(flights);
            earliest.add(Calendar.DAY_OF_MONTH, 1);
            durAdd.add(Calendar.DAY_OF_MONTH, 1);
        }
        Utility.readOneFlights(flights, input);
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(flights.get(0).getUrl()));
    }

    
    @Override
    public void start(Stage stage) throws Exception 
    {
        UI userInterface = new UI(stage);

    }
}