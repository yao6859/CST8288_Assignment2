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
public class BookLaunchTest {
    @Test
    public void testCalculateAdmissionFee() {
        BookLaunch event = new BookLaunch();
        event.calculateAdmissionFee();
        double expValue = 10.0;
        double actValue = event.getAdmissionFees();
        assertEquals(expValue, actValue, 0.01);
    }
}
