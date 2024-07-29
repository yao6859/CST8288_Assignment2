/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;

import com.algonquin.cst8288.assignment2.event.BookLaunch;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.Workshop;

/**
 * The concrete AcademicLibrary class that implements Library
 * 
 * @author yao yi
 */
public class AcademicLibrary implements Library {

    // Override createEvent() method to return a specific object based on user input
    @Override
    public Event createEvent(EventType eventType) {
        switch (eventType) {
            case WORKSHOP:
                return new Workshop();
            case BOOK_LAUNCH:
                return new BookLaunch();
            default:
                throw new IllegalArgumentException("Invalid event type: " + eventType);
        }
    }
    
}
