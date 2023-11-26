package edu.appstate.cs.quintus;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 

public class UI  {

    public UI(Stage stage)
    {
        stage.setTitle("Quintus");

        stage.getIcons().add(new javafx.scene.image.Image(
            getClass().getResourceAsStream("Quintus_Logo.png")));

        StackPane root = new StackPane();

        root.setStyle("-fx-background-color: #333232;");

        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);

        stage.show();
    }

}
