package edu.appstate.cs.quintus;

/**
 * This class contains the method for finding the lowest value
 * between two doubles. 
 * 
 * @author Andrew Tuprin
 * @version 11/2/2023
 */
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
}
