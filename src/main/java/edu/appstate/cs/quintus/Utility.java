package edu.appstate.cs.quintus;


import java.io.File;
import java.io.FileNotFoundException;
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
        flights.add(new Flight(101));
        flights.add(new Flight(111));

        
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
     * @param flights - Put two halves into this linked list.
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
                
                    flights.set(startingIndex++, leftElement);
                    leftIndex++;

                }

                else
                {

                    flights.set(startingIndex++, rightElement);
                    rightIndex++;

                }

            }

            while (leftIndex < leftSub.size())
            {
                flights.set(startingIndex++, leftSub.get(leftIndex++));
            }

            while (rightIndex < rightSub.size())
            {
                flights.set(startingIndex++, rightSub.get(rightIndex++));
            }

         }

         public static void readFlights(String fileName)
         {

            try
            {
                Input input = new Input();
            
                File file = new File(fileName);
            
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

                mergeSortFlights(flights);

                Iterator<Flight> itr = flights.iterator();

                while (itr.hasNext())
                {
                    Flight flight = itr.next();

                    if(input.getStartDate().equals(flight.getStartDate()) &&
                        input.getEndDate().equals(flight.getReturnDate())
                            && Double.parseDouble(input.getCost()) >= flight.getCost())
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

         public static void readTwoFlights(LinkedList<Flight> flights, Input input)
         {

            try
            {
                mergeSortFlights(flights);


                Iterator<Flight> itr = flights.iterator();


                while (itr.hasNext())
                {
                    Flight flight = itr.next();

                    if(input.getStartDate().equals(flight.getStartDate()) &&
                        input.getEndDate().equals(flight.getReturnDate())
                            && Double.parseDouble(input.getCost()) >= flight.getCost())
                    {         
                        System.out.println(flight.toString());
                    }
                
                }
            }

            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Error: Index out of bounds");
            }
            
         }

         public static void readOneFlights(LinkedList<Flight> flights, Input input)
         {

            try
            {
                mergeSortFlights(flights);


                Iterator<Flight> itr = flights.iterator();


                while (itr.hasNext())
                {
                    Flight flight = itr.next();

                    if(input.getStartDate().equals(flight.getStartDate())
                            && Double.parseDouble(input.getCost()) >= flight.getCost())
                    {         
                        System.out.println(flight.toString());
                    }
                
                }
            }

            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Error: Index out of bounds");
            }
            
         }

         




}
