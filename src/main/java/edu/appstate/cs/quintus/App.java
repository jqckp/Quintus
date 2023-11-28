package edu.appstate.cs.quintus;

import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application
{
    /**
    * This is the main method
    */   
    public static void main(String[] args)
    {
        launch(args);
        LinkedList<Flight> flights = new LinkedList<Flight>();
        Input input = new Input();
        Webby webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
        webby.webbyGo(flights);
        Utility.readFlights(flights, input);

        
    }

@Override
    public void start(Stage stage) throws Exception 
    {
        UI userInterface = new UI(stage);

    }
}