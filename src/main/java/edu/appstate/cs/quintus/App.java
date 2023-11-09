package edu.appstate.cs.quintus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App 
{
   /**
    * This is the main method
    */   
   public static void main(String[] args)
   {
        try
        {
            Input input = new Input();
            Lower lower = new Lower();

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
            
            // This is spagetti code becasue of this V
            // System.out.println(Lower.lowestFirst(flights)[0].toString());
            //System.out.println(Lower.lowestFirst(flights)[1].toString());
            //System.out.println(Lower.lowestFirst(flights)[2].toString());
            //System.out.println(Lower.lowestFirst(flights)[69].toString());
            // We don't know why, but we start at one. - Sai, Oscar Andrew
            // We fixed it :), for memories - Sai, Oscar Andrew

            Flight[] fArr = Lower.lowestFirst(flights);

            for(int j = 0; j < fArr.length; j++)
            {
                
                System.out.println(fArr[j]);
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
}