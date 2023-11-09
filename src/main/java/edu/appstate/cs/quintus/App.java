package edu.appstate.cs.quintus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App 
{
   public static void main(String[] args)
   {
        try
        {
            Input input = new Input();

            File file = new File("flight_data.txt");
            
            Scanner s = new Scanner(file);
            String dataValue;
            String start = input.getStartDate();
            String end = input.getEndDate();
            String[] arr = new String[4];
            Flight flight;

            while (s.hasNextLine())
            {
                dataValue = s.nextLine();
                arr = dataValue.split(" ");
                flight = new Flight(arr[0],arr[1],arr[2],Double.parseDouble(arr[3]));
                System.out.println(flight.toString());
            }
    
            

            s.close();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}