package edu.appstate.cs.quintus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App 
{
   public static void main(String[] args)
   {
        try
        {
            Input input = new Input();

            File file = new File("flight_data.txt");
            
            Scanner s = new Scanner(file);

            int i = 0;
            String dataValue;
            String[] arr;
            Flight[] flights = new Flight[70];

            while (s.hasNextLine())
            {
                dataValue = s.nextLine();
                arr = dataValue.split(" ");
                flights[i] = new Flight(arr[0], arr[1], arr[2], Double.parseDouble(arr[3]));
                i++;
            }

            System.out.println("There are " + i + " results");

            s.close();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}