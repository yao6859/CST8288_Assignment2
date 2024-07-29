/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.database;

import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * JUnit test class for DBConnection
 * 
 * @author yao yi
 */
public class DBConnectionTest {
    @Test
    public void testSingleton() throws SQLException {
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();

        assertSame("Two instance didn't refer to the same object, violate Singleton Pattern", instance1, instance2);
    }

}



