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

<<<<<<< HEAD
        //Utility.readFlights("flights_data.txt");


=======
        Utility.readFlights("flights_data.txt");
>>>>>>> bd385e61d4b0e54b071754d1f9e6c81388a15a75
        
    }

@Override
    public void start(Stage stage) throws Exception 
    {
        UI userInterface = new UI(stage);

    }
}