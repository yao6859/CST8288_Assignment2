package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import java.util.Scanner;

/**
 * This Client class contains main method to run the program
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class Client {
	
	public static void main(String[] args) {
            LMSLogger logger = LMSLogger.getInstance();
            Scanner scanner = new Scanner(System.in);
            
            // Create new events based on user inputs
            System.out.println("Create an event by type");
            System.out.println("Enter type number(1 - Book Launch, 2 - Kids Story Time, 3 - Movie Night, 4 - Workshop): ");
            int eventTypeInput = scanner.nextInt();
            EventType eventType = null;
            switch (eventTypeInput) {
                case 1:
                    eventType = EventType.BOOK_LAUNCH;
                    break;
                case 2:
                    eventType = EventType.KIDS_STORY;
                    break;
                case 3:
                    eventType = EventType.MOVIE_NIGHT;
                    break;
                case 4:
                    eventType = EventType.WORKSHOP;
                    break;
                default:
                    logger.log(LogLevel.ERROR, "Invalid event type entered.");
            }
            
            Library library = DBOperations.getLibraryForEventType(eventType);
            Event newEvent = library.createEvent(eventType);
            if (newEvent == null) {
                logger.log(LogLevel.ERROR, "Failed to create new event.");
            } else {
                System.out.println("Enter event description:");
                scanner.nextLine();
                String description = scanner.nextLine();
                newEvent.setEventDescription(description);
                
                System.out.println("Enter event activities:");
                String activity = scanner.nextLine();
                newEvent.setEventActivities(activity);
                newEvent.calculateAdmissionFee();
                DBOperations.createEvent(newEvent);
                
                logger.log(LogLevel.INFO, "New event: " + newEvent.getEventName() + " created successfully");
            }
            
            // Retrieve events by ID and print in the console window
            System.out.println();
            System.out.println("View an event by event ID");
            System.out.println("Enter event ID: ");
            int id = scanner.nextInt();
//            Event newEvent;
            newEvent = DBOperations.retrieveEvent(id);
            newEvent.printEvent();
            
            logger.log(LogLevel.INFO, "Event with ID: " + newEvent.getEventID() + " retrieved successfully");
            
            // Update an existing event by ID
            System.out.println();
            System.out.println("Update retrieved event");
            newEvent.setEventID(id);
            System.out.println("Enter description:");
            scanner.nextLine();
            String newDescription = scanner.nextLine();
            newEvent.setEventDescription(newDescription);
            
            System.out.println("Enter activities:");
            String newActivity = scanner.nextLine();
            newEvent.setEventActivities(newActivity);
            DBOperations.updateEvent(newEvent);
            newEvent.printEvent();
            
            logger.log(LogLevel.INFO, "Event with ID: " + newEvent.getEventID() + " has been updated");
            
            // Delete an event by ID
            System.out.println();
            System.out.println("Delete an event by event ID");
            System.out.println("Enter event ID: ");
            int id2 = scanner.nextInt();
//            Event newEvent = DBOperations.retrieveEvent(id2);
            DBOperations.deleteEvent(id2);
            
            logger.log(LogLevel.INFO, "Event with ID: " + newEvent.getEventID() + " has been deleted");
            
        }
}
