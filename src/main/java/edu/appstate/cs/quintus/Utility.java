package edu.appstate.cs.quintus;


/**
 * This class contains the method for finding the lowest value
 * between two doubles. 
 * 
 * @author Andrew Tuprin
 * @version 11/2/2023
 */
import java.util.*;




public class Utility 
{

    private static LinkedList<Flight> flights = new LinkedList<>();
    

    

    

    public static void main(String[] args)
    {


        flights.add(new Flight(444));
        flights.add(new Flight(500));
        flights.add(new Flight(100));
        flights.add(new Flight(260));
        

        
        System.out.println(flights.size());

        mergeSortFlights(flights);

        System.out.println(flights.size());



        for (Flight flight : flights)
        {
            System.out.println(flight.toString());
        }



    }





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
     * Merge sort algorithm to sort a linked list of flights by price in ascending order.
     * 
     * @author - Jack Porter
     * @param flights - List of flights to sort.
     */
    public static void mergeSortFlights(LinkedList<Flight> flights)
    {

        int length = flights.size();

        //Base case, linked lists are 1 element
        if (length < 2)
        {
            return;
        }

        int middle = length / 2;


        LinkedList<Flight> leftSub = new LinkedList<>(flights.subList(0, middle));
        LinkedList<Flight> rightSub = new LinkedList<>(flights.subList(middle, length));

    

        mergeSortFlights(leftSub);
        mergeSortFlights(rightSub);


        merge(leftSub, rightSub, flights);

    }

    /**
     * Helper method to merge split linked lists.
     * 
     * 
     * @author - Jack Porter
     * 
     * @param leftSub - Left half of the linked list.
     * @param rightSub - Right half of the linked list.
     * @param flights - Merge two halves into this linked list.
     */
    private static void merge(LinkedList<Flight> leftSub,
         LinkedList<Flight> rightSub, LinkedList<Flight> flights)
         {
            

            int leftIndex = 0;
            int rightIndex = 0;
            int startingIndex = 0;


            while (leftIndex < leftSub.size() && rightIndex < rightSub.size())
            {
                Flight leftElement = leftSub.get(leftIndex);
                Flight rightElement = rightSub.get(rightIndex);


                if (leftElement.getCost() <= rightElement.getCost())
                {
                
                    flights.add(startingIndex++, leftElement);
                    leftIndex++;

                }

                else
                {

                    flights.add(startingIndex++, rightElement);
                    rightIndex++;

                }

            }

            while (leftIndex < leftSub.size())
            {
                flights.add(startingIndex++, leftSub.get(leftIndex++));
            }

            while (rightIndex < rightSub.size())
            {
                flights.add(startingIndex++, rightSub.get(rightIndex++));
            }


         }

         




}