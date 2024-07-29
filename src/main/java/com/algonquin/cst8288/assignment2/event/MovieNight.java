/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.MOVIE_NIGHT_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.MOVIE_NIGHT_RATE;

/**
 * This class inherits the Event class, represents a specific type of event: movie night
 *
 * @author yao yi
 */
public class MovieNight extends Event {
    
    // Constructor
    public MovieNight() {
        this.eventName = "Movie Night";
    }

    // Override the calculateAdmissionFee method to calculate the fees of a movie night event
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = MOVIE_NIGHT_DURATION * MOVIE_NIGHT_RATE;
    }
}
