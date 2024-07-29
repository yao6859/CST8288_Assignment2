/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yao yi
 */
public class MovieNightTest {
    @Test
    public void testCalculateAdmissionFee() {
        MovieNight event = new MovieNight();
        event.calculateAdmissionFee();
        double expValue = 7.5;
        double actValue = event.getAdmissionFees();
        assertEquals(expValue, actValue, 0.01);
    }
}
