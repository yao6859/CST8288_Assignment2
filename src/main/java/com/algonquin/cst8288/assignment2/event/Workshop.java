/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.WORKSHOP_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.WORKSHOP_RATE;

/**
 * This class inherits the Event class, represents a specific type of event: workshop
 *
 * @author yao yi
 */
public class Workshop extends Event {
    // Constructor
    public Workshop() {
        this.eventName = "Workshop";
    }

    // Override the calculateAdmissionFee method to calculate the fees of a workshop
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = WORKSHOP_DURATION * WORKSHOP_RATE;
    }
    
}
