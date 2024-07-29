/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import static com.algonquin.cst8288.assignment2.constants.Constants.BOOK_LAUNCH_DURATION;
import static com.algonquin.cst8288.assignment2.constants.Constants.BOOK_LAUNCH_RATE;


/**
 * This class inherits the Event class, represents a specific type of event: book launch 
 *
 * @author yao yi
 */
public class BookLaunch extends Event {
    // Constructor
    public BookLaunch() {
        this.eventName = "Book Launch";
    }

    // Override the calculateAdmissionFee method to calculate the fees of a book launch event
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = BOOK_LAUNCH_DURATION * BOOK_LAUNCH_RATE;
    }
}
