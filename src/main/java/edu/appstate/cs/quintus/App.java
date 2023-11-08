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

            File file = new File("delta.txt");
            
            Scanner s = new Scanner(file);

            int i = 0;
            String dataValue;
            String start = input.getStartDate();
            String end = input.getEndDate();

            while (s.hasNextLine())
            {
                dataValue = s.nextLine();
                if(dataValue.equals(start + " " + end))
                {
                    i++;
                }
            }
    
            System.out.println("There are " + i + " flights that match with your inputs");

            s.close();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}