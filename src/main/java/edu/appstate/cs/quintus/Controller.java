package edu.appstate.cs.quintus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Defines functionality of Quintus UI.
 * 
 * @author Jack Porter, Dattasai Sagili
 * @version 12/06/2023
 */
public class Controller implements Initializable
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
    private ComboBox<String> autoBox1;

    @FXML
    private ComboBox<String> autoBox2;

    @FXML
    private TextField departureLocation;

    @FXML
    private TextField destination;

    @FXML
    private TextField maxPrice;

    @FXML
    private TextField duration;

    @FXML
    private Label dateError;

    @FXML
    private Label numberError;

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

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

    private LocalDate destinDate;

    private String departCode;

    private String destinCode;

    private ObservableList<Flight> flightsToDisplay = FXCollections.observableArrayList();

    private ObservableList<String> locationsToDisplay;

    private LinkedList<Flight> flights;

    private LinkedList<Flight> filteredFlightList;

    private Flight selectedItem;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setPossibleLocations();
        autoBox1.setVisibleRowCount(5);
        autoBox2.setVisibleRowCount(5);
        autoBox1.setVisible(false);
        autoBox2.setVisible(false);

        departureLocation.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (!newValue.isEmpty()) 
            {
                ObservableList<String> filteredData = FXCollections.observableArrayList();
                for (String item : locationsToDisplay) 
                {
                    if (item.toLowerCase().contains(newValue.toLowerCase())) 
                    {
                        filteredData.add(item);
                    }
                }
                autoBox1.setItems(filteredData);
                autoBox1.show();
            } 
            else 
            {
                autoBox1.hide();
            }
        });

        destination.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (!newValue.isEmpty()) 
            {
                ObservableList<String> filteredData = FXCollections.observableArrayList();
                for (String item : locationsToDisplay) 
                {
                    if (item.toLowerCase().contains(newValue.toLowerCase())) 
                    {
                        filteredData.add(item);
                    }
                }
                autoBox2.setItems(filteredData);
                autoBox2.show();
            } 
            else 
            {
                autoBox2.hide();
            }
        });

        autoBox1.setOnAction(event -> {
            String selectedValue = autoBox1.getSelectionModel().getSelectedItem();
            if (selectedValue != null) 
            {
                departureLocation.setText(selectedValue);
                autoBox1.hide();
            }
        });

        autoBox2.setOnAction(event -> {
            String selectedValue = autoBox2.getSelectionModel().getSelectedItem();
            if (selectedValue != null) 
            {
                destination.setText(selectedValue);
                autoBox2.hide();
            }
        });
    }
    
    @FXML
    private void goToFlight()
    {
        Flight goTo = flightData.getSelectionModel().getSelectedItem();

        Desktop desktop = Desktop.getDesktop();

        try 
        {
            desktop.browse(new URI(goTo.getUrl()));
        } 
        catch (IOException e) 
        {
            System.out.println("Select Flight");
        } 
        catch (URISyntaxException e) 
        {
            System.out.println("Select Flight");
        }
    }

    @FXML
    private void clearLocation(ActionEvent e)
    {
        departureLocation.clear();
        destination.clear();
        autoBox1.hide();
        autoBox2.hide();
    }

    @FXML
    private void clearDates(ActionEvent e)
    {
        departureDate.setValue(null);
        returnDate.setValue(null);
        dateError.setText("");
    }

    @FXML
    private void clearPrice(ActionEvent e)
    {
        maxPrice.clear();
        duration.clear();
        numberError.setText("");
    }

    @FXML
    private void reset(ActionEvent e)
    {
        departureLocation.clear();
        destination.clear();
        maxPrice.clear();
        departureDate.setValue(null);
        returnDate.setValue(null);
        flightData.getItems().clear();
        duration.clear();
    }

    @FXML
    private void search(ActionEvent e)
    {        
        flightData.getItems().clear();
        filteredFlightList = new LinkedList<>();
        flights = new LinkedList<Flight>();
        WebDriver driver = new ChromeDriver();
        Input input = new Input();
        Webby webby;

        String date;
        int year;
        int month;
        int day;

        String date2;
        int year2;
        int month2;
        int day2;


        try
        {
            dateError.setText("");;
            numberError.setText("");
            int t = 0; 
            if(datePickerNull(departureDate, returnDate))
            {
                dateError.setText("Please select a date.");
                t++;                
            }
            else
            {
                departDate = departureDate.getValue();
                destinDate = returnDate.getValue();
                if(datesNull(departDate, destinDate))
                {
                    t++;
                    dateError.setText("Please select an appropriate date.");
                }
                else if(datesIncorrect(departDate, destinDate, currentDate))
                {
                    t++;
                    dateError.setText("Order should be current -> start -> end");
                }
            }
            if(!(isNumberValid(maxPrice.getText()) && isNumberValid(duration.getText())))
            {
                t++;
                numberError.setText("Enter in a valid number please.");
            }

            if(t == 0)
            {
                departCode = gettingCode(departureLocation.getText());
                destinCode = gettingCode(destination.getText());
                
                int dur = Integer.parseInt(duration.getText());
                input.setCost(maxPrice.getText());
                String startDate = departDate.format(formatter);
                String endDate = destinDate.format(formatter);
                String[] startDateArr = startDate.split("-");
                String[] endDateArr = endDate.split("-");

                Calendar earliest = Calendar.getInstance();
                earliest.set(Integer.parseInt(startDateArr[0]), Integer.parseInt(startDateArr[1]) - 1,
                            Integer.parseInt(startDateArr[2]));
                Calendar latest  = Calendar.getInstance();
                latest.set(Integer.parseInt(endDateArr[0]), Integer.parseInt(endDateArr[1]) - 1,
                            Integer.parseInt(endDateArr[2]));
                Calendar durAdd = Calendar.getInstance();
                durAdd.set(Integer.parseInt(startDateArr[0]), Integer.parseInt(startDateArr[1]) - 1,
                            Integer.parseInt(startDateArr[2]));
                durAdd.add(Calendar.DAY_OF_MONTH, dur);

                if(dur == 0)
                {
                    while(earliest.compareTo(latest) <= 0)
                    {
                        year = earliest.get(Calendar.YEAR);
                        month = earliest.get(Calendar.MONTH) + 1;
                        day = earliest.get(Calendar.DAY_OF_MONTH);
                        if(month < 10 && day < 10)
                        {
                            date = year + "-0" + month + "-0" + day;
                        }
                        else if (day < 10)
                        {
                            date = year + "-" + month + "-0" + day;
                        }
                        else if (month < 10)
                        {
                            date = year + "-0" + month + "-" + day;
                        }
                        else
                        {
                            date = year + "-" + month + "-" + day;
                        }

                        input.setInput(date, departCode, destinCode);
                
                        webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
                        webby.webbyOneAirline(flights, driver);

                        earliest.add(Calendar.DAY_OF_MONTH, 1);

                    }
                    driver.quit();

                    Utility.mergeSortFlights(flights);


                    Iterator<Flight> itr = flights.iterator();


                    while (itr.hasNext())
                    {
                        Flight flight = itr.next();

                        if(Double.parseDouble(input.getCost()) >= flight.getCost())
                        {         
                            filteredFlightList.add(flight);
                        }
                
                    }
                }
                else
                {
                    while(durAdd.compareTo(latest) <= 0)
                    {
                        year = earliest.get(Calendar.YEAR);
                        month = earliest.get(Calendar.MONTH) + 1;
                        day = earliest.get(Calendar.DAY_OF_MONTH);
                        date = year + "-" + month + "-" + day;

                        if(month < 10 && day < 10)
                        {
                            date = year + "-0" + month + "-0" + day;
                        }
                        else if (day < 10)
                        {
                            date = year + "-" + month + "-0" + day;
                        }
                        else if (month < 10)
                        {
                            date = year + "-0" + month + "-" + day;
                        }
                        else
                        {
                            date = year + "-" + month + "-" + day;
                        }

                        year2 = durAdd.get(Calendar.YEAR);
                        month2 = durAdd.get(Calendar.MONTH) + 1;
                        day2 = durAdd.get(Calendar.DAY_OF_MONTH);
                        date2 = year2 + "-" + month2 + "-" + day2;

                        if(month2 < 10 && day2 < 10)
                        {
                            date2 = year2 + "-0" + month2 + "-0" + day2;
                        }
                        else if (day2 < 10)
                        {
                            date2 = year2 + "-" + month2 + "-0" + day2;
                        }
                        else if (month2 < 10)
                        {
                            date2 = year2 + "-0" + month2 + "-" + day2;
                        }
                        else
                        {
                            date2 = year2 + "-" + month2 + "-" + day2;
                        }

                        input.setInput(date, date2, departCode, destinCode);

                        webby = new Webby(input.getStartLocation(), input.getEndLocation(), input.getStartDate(), input.getEndDate());
                        webby.webbyTwoAirline(flights, driver);

                        earliest.add(Calendar.DAY_OF_MONTH, 1);
                        durAdd.add(Calendar.DAY_OF_MONTH, 1);
                    }
                    driver.quit();

                    Utility.mergeSortFlights(flights);


                    Iterator<Flight> itr = flights.iterator();


                    while (itr.hasNext())
                    {
                        Flight flight = itr.next();

                        if(Double.parseDouble(input.getCost()) >= flight.getCost())
                        {         
                            filteredFlightList.add(flight);
                        }
                
                    }
                }

                flightsToDisplay.addAll(filteredFlightList);

                flightData.setItems(flightsToDisplay);
            }            
        }
        catch (NullPointerException ex)
        {
            System.out.println("null");
        }      
    }

    private boolean isNumberValid(String input)
    {
        try
        {
            double number = Double.parseDouble(input);
            return number >= 0 && number < 100000;            
        }
        catch (NumberFormatException ex)
        {
            return false;            
        }
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

    private void setPossibleLocations()
    {
        locationsToDisplay = FXCollections.observableArrayList();
        for(AirportCode loc : AirportCode.values())
        {
            locationsToDisplay.add(loc.getLocation());
        }
    }

    private String gettingCode(String input)
    {
        String output = "";
        for(AirportCode cod : AirportCode.values())
        {
            if (input.equals(cod.getLocation()))
            {
                output = cod.getCode();
            }
        }
        return output;
    }
}
