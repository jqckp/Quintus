package edu.appstate.cs.quintus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Defines functionality of Quintus UI.
 * 
 * @author Jack Porter
 * @version 11/27/2023
 */
public class Controller 
{
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
            LocalDate selectedDate = departureDate.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String startDate = selectedDate.format(formatter);
            selectedDate = returnDate.getValue();
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String endDate = selectedDate.format(formatter);
            LinkedList<Flight> flights = new LinkedList<Flight>();
            Input input = new Input();
            input.setInput(startDate, endDate, maxPrice.getText(), departureLocation.getText(), destination.getText());
            Webby webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
            webby.webbyGo(flights);

            try
            {
                Utility.mergeSortFlights(flights);


                Iterator<Flight> itr = flights.iterator();


                while (itr.hasNext())
                {
                    Flight flight = itr.next();

                    if(input.getStartDate().equals(flight.getStartDate()) &&
                        input.getEndDate().equals(flight.getReturnDate())
                            && Double.parseDouble(input.getCost()) >= flight.getCost())
                    {         
                        flightData.appendText(flight.toString() + "\n");
                    }
                
                }
            }

            catch (ArrayIndexOutOfBoundsException ex)
            {
                System.out.println("Error: Index out of bounds");
            }

        errorMessage.setText("Searching...");


        } catch (NumberFormatException ex)
        {
            System.out.println("Enter a number");
        }

        catch (IllegalArgumentException ex)
        {
            errorMessage.setText("Invalid max price");
            
        }

        catch (NullPointerException ex)
        {
            System.out.println("Make sure to enter both dates");
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
