/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import com.algonquin.cst8288.assignment2.event.MovieNight;

/**
 * The concrete PublicLibrary class that implements Library
 * 
 * @author yao yi
 */
public class PublicLibrary implements Library {

    // Override createEvent() method to return a specific object based on user input
    @Override
    public Event createEvent(EventType eventType) {
        switch (eventType) {
            case MOVIE_NIGHT:
                return new MovieNight();
            case KIDS_STORY:
                return new KidsStoryTime();
            default:
                throw new IllegalArgumentException("invalid event type: " + eventType);
        }
    }
    
}
