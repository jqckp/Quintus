package edu.appstate.cs.quintus;

import java.io.IOException;



import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader; 


/**
 * Loads scene into stage and sets title, logo, background, etc.
 * Formatting loaded from Main.fxml.
 * Functionality located in Controller class.
 * 
 * @author Jack Porter
 * @version 11/27/2023
 */
public class UI {


    public UI(Stage stage)
    {

        try
        {
            
            Parent root = FXMLLoader.load(getClass().getResource("UI_Resources/Main.fxml"));
            
            Scene scene = new Scene(root);


            Font.loadFont(getClass().getResourceAsStream("UI_Resources/Alien AI.ttf"), 12);


            stage.setTitle("Quintus");

            stage.getIcons().add(new javafx.scene.image.Image(getClass()
                .getResourceAsStream("UI_Resources/Quintus_Logo.png")));

            stage.setScene(scene);

            stage.setResizable(false);

            stage.show();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
            
    }

    



}
