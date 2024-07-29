/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.logger;

import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for LMSLogger
 * 
 * @author yao yi
 */
public class LMSLoggerTest {
    @Test
    public void testSingleton() throws SQLException {
        LMSLogger logger1 = LMSLogger.getInstance();
        LMSLogger logger2 = LMSLogger.getInstance();
        
        assertSame("Two instance didn't refer to the same object, violate Singleton Pattern", logger1, logger2);
    }
}
