package edu.appstate.cs.quintus;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 

public class UI extends Application implements EventHandler<ActionEvent>
{
    Button button;
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage s) throws Exception 
    {
        try
        {
            s.setTitle("Quintus");
            new Button();
            button.setText("Enter");
            button.setOnAction(this);

            StackPane layout = new StackPane();
            layout.getChildren().add(button);

            Scene scene = new Scene(layout, 300, 250);
            s.setScene(scene);
            s.show();
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void handle(ActionEvent event)
    {
        if(event.getSource() == button)
        {
            System.out.println("Ooooo....I love it when you touch me there....");
        }
    }
}
