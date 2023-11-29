package edu.appstate.cs.quintus;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Defines functionality of Quintus UI.
 * 
 * @author Jack Porter
 * @version 11/27/2023
 */
public class Controller {
    


    private static String DATE_PATTERN = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4})$";

    @FXML
    private Button locationClear;

    @FXML
    private Button dateClear;

    @FXML
    private Button priceClear;

    @FXML
    private Button search;

    @FXML
    private Button reset;

    @FXML
    private TextField departureLocation;

    @FXML
    private TextField destination;

    @FXML
    private TextField maxPrice;

    @FXML
    private Label errorMessage;

    @FXML
    private DatePicker departureDate;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TextArea flightData;

    private Date currentDate;



    @FXML
    private void clearLocation(ActionEvent e)
    {
        departureLocation.clear();
        destination.clear();

    }

    @FXML
    private void clearDates(ActionEvent e)
    {
        departureDate.setValue(null);
        returnDate.setValue(null);

    }

    @FXML
    private void clearPrice(ActionEvent e)
    {
        maxPrice.clear();
    }

    @FXML
    private void search(ActionEvent e)
    {
        
        try
        {
            
            double priceLimit = Double.parseDouble(maxPrice.getText());

            
            //System.out.println(departureDate.getValue().toString());
            //System.out.println(returnDate.getValue().toString());


            if (validateMaxPrice(priceLimit) && validateDates())
            {
                System.out.println("Thank you for entering valid price limit");
            }

            errorMessage.setText("Searching...");


        } catch (NumberFormatException ex)
        {
            errorMessage.setText("Price entered is not a number");
        }

        catch (IllegalArgumentException ex)
        {
            errorMessage.setText("Invalid max price");
            
        }

        catch (NullPointerException ex)
        {
            System.out.println("Empty fields");
        }

        

        
    }



    private boolean validateMaxPrice(double priceLim)
    {
        if (!(priceLim >= 0 && priceLim < Integer.MAX_VALUE))
        {
            throw new IllegalArgumentException();
        }

        return true;
    }

    private boolean validateDates()
    {
        currentDate = new Date();

        if (departureDate == null || returnDate == null)
        {
            return false;
        }

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //String dateToCompare = dateFormat.format(currentDate).toString();



        return true;
    }

}
