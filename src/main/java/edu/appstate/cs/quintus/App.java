package edu.appstate.cs.quintus;

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
    }

    @SuppressWarnings("unused")
    @Override
    public void start(Stage stage) throws Exception 
    {
        UI userInterface = new UI(stage);

    }
}