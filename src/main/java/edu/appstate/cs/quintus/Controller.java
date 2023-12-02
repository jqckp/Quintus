package edu.appstate.cs.quintus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private Button goToFlight;

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
    private ListView<Flight> flightData;

    private LocalDate currentDate = LocalDate.now();

    private LocalDate departDate;

    private String pattern = "yyyy-MM-dd";

    private LocalDate destinDate;

    private ObservableList<Flight> flightsToDisplay = FXCollections.observableArrayList();
    private LinkedList<Flight> flights;

    private LinkedList<Flight> filteredFlightList;

    private Flight selectedItem;


    @FXML
    private void goToFlight()
    {

        


    }

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
        //flightData.clear();
        departureLocation.clear();
        destination.clear();
        maxPrice.clear();
        departureDate.setValue(null);
        returnDate.setValue(null);
        flightData.getItems().clear();
    }

    @FXML
    private void search(ActionEvent e)
    {        
        filteredFlightList = new LinkedList<>();


        try
        {
            
            int t = 0;
            //double priceLimit = Double.parseDouble(maxPrice.getText()); 
            if(datePickerNull(departureDate, returnDate))
            {
                System.out.println("Please select a date.");
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
                flights = new LinkedList<Flight>();
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
                        filteredFlightList.add(flight);
                    }
                }

                flightsToDisplay.addAll(filteredFlightList);

                flightData.setItems(flightsToDisplay);








            }            
        }

        catch (NumberFormatException ex)
        {
            
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
            throw new IllegalArgumentException("Invalid price");
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
