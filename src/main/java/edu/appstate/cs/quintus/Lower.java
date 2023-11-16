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
}
