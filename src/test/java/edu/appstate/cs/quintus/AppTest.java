package edu.appstate.cs.quintus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest
{
    //@Test
    //public void testApp()
    //{
    //    assertTrue(true, "This should never fail");
    //}

    //@Test
    //public void testSum()
    //{
        //assertEquals(3, App.sum(1,2), "1 + 2 should be 3");
    //}

    @Test
    public void testLower()
    {
        assertEquals(2.0, Lower.lower(2.0,4.0), "2.0 is lower than 4.0");
        assertEquals(2.0, Lower.lower(4.0,2.0), "4.0 is higher than 2.0");
    }
}
