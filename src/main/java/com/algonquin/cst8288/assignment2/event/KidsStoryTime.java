/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.KIDS_STORYTIME_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.KIDS_STORYTIME_RATE;

/**
 * This class inherits the Event class, represents a specific type of event: kids story time
 *
 * @author yao yi
 */
public class KidsStoryTime extends Event {
    
    // Constructor
    public KidsStoryTime() {
        this.eventName = "Kids Story Time";
    }

    // Override the calculateAdmissionFee method to calculate the fees of a kids story time event
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = KIDS_STORYTIME_DURATION * KIDS_STORYTIME_RATE;
    }
}
