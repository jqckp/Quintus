package edu.appstate.cs.quintus;

import java.io.File;
import java.io.FileNotFoundException;
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

        //Utility.readFlights("flights_data.txt");


        
    }

@Override
    public void start(Stage stage) throws Exception 
    {
        UI userInterface = new UI(stage);

    }
}