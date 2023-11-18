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



        try
        {
            Input input = new Input();
            

            File file = new File("flight_data.txt");
            
            Scanner s = new Scanner(file);

            String dataValue;
            String[] arr;
            LinkedList<Flight> flights = new LinkedList<>();

            while (s.hasNextLine())
            {
                dataValue = s.nextLine();
                arr = dataValue.split(" ");
                flights.add(new Flight(arr[0], arr[1], arr[2], Double.parseDouble(arr[3])));
            }
            
            // This is spagetti code becasue of this V
            // System.out.println(Lower.lowestFirst(flights)[0].toString());
            //System.out.println(Lower.lowestFirst(flights)[1].toString());
            //System.out.println(Lower.lowestFirst(flights)[2].toString());
            //System.out.println(Lower.lowestFirst(flights)[69].toString());
            // We don't know why, but we start at one. - Sai, Oscar Andrew
            // We fixed it :), for memories - Sai, Oscar Andrew


            

            //Lower.mergeSortFlights(flights);

            int i = 0;
            for (Flight flight : flights)
            {
                System.out.println(flight);
                i++;
            }

            System.out.println(i);

            System.exit(0);
            

            Iterator<Flight> itr = flights.iterator();


            while (itr.hasNext())
            {
                Flight flight = itr.next();

                if(input.getStartDate().equals(flight.getStartDate()) &&
                    input.getEndDate().equals(flight.getReturnDate())
                         && Double.parseDouble(input.getCost()) > flight.getCost())
                {         
                    System.out.println(flight.toString());
                }
                
            }
            
            s.close();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error: Index out of bounds");
        }
    }

@Override
public void start(Stage stage) throws Exception 
{
    UI userInterface = new UI(stage);

    stage.show();
}
}