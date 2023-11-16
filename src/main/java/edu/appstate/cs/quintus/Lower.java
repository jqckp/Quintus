package edu.appstate.cs.quintus;


/**
 * This class contains the method for finding the lowest value
 * between two doubles. 
 * 
 * @author Andrew Tuprin
 * @version 11/2/2023
 */

import java.util.LinkedList;
import java.util.*;




public class Lower 
{
    /**
     * This method compares "o" (the original/previous lowest vale) with
     * "n" (the new value to be compared). 
     * 
     * @param o - the original value (first or previous lowes).
     * @param n - the new value to be compared.
     * @return the new lowest value.
     */
    public static double lower(double o, double n)
    {
        if (o <= n)
        {
            n = o;
        }
        return n;
    }


    //this is assuming that all data is correct
    /*
     * Lowest first is a class that takes an array of the Flight object
     * and orders them using a selection sort (lowest to hightest).
     * 
     * @author Andrew Turpin
     * @version 11/9/2023
     * @return narr - the new array
     */
    public static Flight[] lowestFirst(Flight[] arr)
    {
        Flight[] narr = arr;
        //Flight lowest = narr[0];
        int minIndex = 0;
        for (int i = 0; i < narr.length - 1; i++)
        {
            
            for (int j = i + 1; j < narr.length; j++)
            {
                if (narr[j].getCost() < narr[minIndex].getCost())
                {
                    minIndex = j;
                }
            }

            Flight temp = narr[minIndex];
            narr[minIndex] = narr[i];
            narr[i] = temp;

        }

        return narr;
    }



    

    /**
     * Merge sort method to sort a linked list of flights by price in ascending order.
     * 
     * @author - Jack Porter
     * @param flights - List of flights to sort.
     */
    public static void mergeSortFlights(LinkedList<Flight> flights)
    {

        int flightsIndex = 0;
        
        
        int length = flights.size();

        if (length < 2)
        {
            return;
        }

        int middle = length / 2;


        LinkedList<Flight> leftSub = new LinkedList<>(flights.subList(0, middle));
        LinkedList<Flight> rightSub = new LinkedList<>(flights.subList(middle, length));
        
        mergeSortFlights(leftSub);
        mergeSortFlights(rightSub);


        flightsIndex = merge(leftSub, rightSub, flights, flightsIndex);

    }

    /**
     * Helper method to merge split linked lists back together.
     * 
     * 
     * @author - Jack Porter
     * 
     * @param leftSub - Left half of the linked list.
     * @param rightSub - Right half of the linked list.
     * @param flights - Merge two halves into this linked list.
     */
    private static int merge(LinkedList<Flight> leftSub,
         LinkedList<Flight> rightSub, LinkedList<Flight> flights, int flightsIndex)
         {
            Iterator<Flight> leftItr = leftSub.iterator();
            Iterator<Flight> rightItr = rightSub.iterator();
            
            
            
            if (leftItr.next() == null)
            {
                emptyRight(rightItr, flights, flightsIndex);
                return flightsIndex;
            }

            if (rightItr.next() == null)
            {
                emptyLeft(leftItr, flights, flightsIndex);
                return flightsIndex;
            }
           
            

            while (leftItr.hasNext() && rightItr.hasNext())
            {

                Flight leftElement = leftItr.next();
           
           
                Flight rightElement = rightItr.next();


                if (leftElement.getCost() <= rightElement.getCost())
                {
                    flights.set(flightsIndex++, leftElement);
                    leftElement = leftItr.next();
                    
                }

                else
                {
                    flights.set(flightsIndex++, rightElement);
                    rightElement = rightItr.next();
                }

                
            }

            if (leftItr.hasNext())
            {
                emptyLeft(leftItr, flights, flightsIndex);
            }

            if (rightItr.hasNext())
            {
                emptyRight(rightItr, flights, flightsIndex);
            }

            return flightsIndex;

         }

         private static void emptyRight(Iterator<Flight> rightItr, LinkedList<Flight> flights, Integer flightsIndex)
         {
                while (rightItr.hasNext())
                {
                    flights.set(flightsIndex, rightItr.next());
                    flightsIndex++;
                }
                
         }

         private static void emptyLeft(Iterator<Flight> leftItr, LinkedList<Flight> flights, Integer flightsIndex)
         {
            while (leftItr.hasNext())
            {
                flights.set(flightsIndex, leftItr.next());
                flightsIndex++;

            }
            
         }


}
