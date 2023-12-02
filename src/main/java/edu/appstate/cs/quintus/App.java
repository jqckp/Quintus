package edu.appstate.cs.quintus;

import java.util.LinkedList;
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


        
        //LinkedList<Flight> flights = new LinkedList<Flight>();
        //Input input = new Input();
        //input.setInput("2023-12-14", "10000", "CLT", "NYC");
        //Webby webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
        //webby.webbyOneAirline(flights);
        //Utility.readOneFlights(flights, input);
        //Desktop desktop = Desktop.getDesktop();
        //desktop.browse(new URI(flights.get(0).getUrl()));
    }

    
    @Override
    public void start(Stage stage) throws Exception 
    {
        UI userInterface = new UI(stage);

    }
}