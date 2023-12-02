package edu.appstate.cs.quintus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.awt.Desktop;
import java.net.URI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.bytebuddy.asm.Advice.Local;

/**
 * Defines functionality of Quintus UI.
 * 
 * @author Jack Porter
 * @version 11/27/2023
 */
public class Controller 
{
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

    private String pattern = "yyyy-MM-dd";

    private LocalDate currentDate = LocalDate.now();

    private LocalDate departDate;

    private LocalDate destinDate;

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
    private void reset(ActionEvent e)
    {
        flightData.clear();
        departureLocation.clear();
        destination.clear();
        maxPrice.clear();
        departureDate.setValue(null);
        returnDate.setValue(null);
    }
    @FXML
    private void search(ActionEvent e)
    {        
        try
        {
            flightData.clear();
            int t = 0;
            //double priceLimit = Double.parseDouble(maxPrice.getText()); 
            if(datePickerNull(departureDate, returnDate))
            {
                System.out.println("Please select an date.");
                t++;                
            }
            else
            {
                departDate = departureDate.getValue();
                destinDate = returnDate.getValue();
                if(datesNull(departDate, destinDate))
                {
                    t++;
                    System.out.println("Please select an appropriate date.");
                }
                else if(datesIncorrect(departDate, destinDate, currentDate))
                {
                    t++;
                    System.out.println("order should be current -> start -> end");
                }
            }

            if(t == 0)
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                String startDate = departDate.format(formatter);
                String endDate = destinDate.format(formatter);
                LinkedList<Flight> flights = new LinkedList<Flight>();
                Input input = new Input();
                input.setInput(startDate, endDate, maxPrice.getText(), departureLocation.getText(), destination.getText());
                Webby webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
                webby.webbyTwoAirline(flights);

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
        }

        catch (NumberFormatException ex)
        {
            System.out.println("Enter a number");
        }

        catch (IllegalArgumentException ex)
        {
            errorMessage.setText("Invalid max price");
        }

        catch (NullPointerException ex)
        {
            ex.printStackTrace();
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

    private boolean datePickerNull(DatePicker d1, DatePicker d2)
    {
        return departureDate == null || returnDate == null;
    }

    private boolean datesNull(LocalDate l1, LocalDate l2)
    {
        return l1 == null || l2 == null;
    }

    private boolean datesIncorrect(LocalDate start, LocalDate end, LocalDate current)
    {
        return current.compareTo(start) > 0 || current.compareTo(end) > 0 || start.compareTo(end) > 0;
    }

}
