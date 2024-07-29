package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Class to define fundamental CRUD (Create, Read, Update, Delete) operations
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class DBOperations {

        // Method to create a new event, passing parameter event of type Event
	public static void createEvent(Event event) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = DBConnection.getInstance().getConnection();

                pstmt = con.prepareStatement(
                        "INSERT INTO events (event_name, event_description, event_activities, admission_fees) "
                        + "VALUES(?, ?, ?, ?)");
                pstmt.setString(1, event.getEventName());
                pstmt.setString(2, event.getEventDescription());
                pstmt.setString(3, event.getEventActivities());
                pstmt.setDouble(4, event.getAdmissionFees());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
	}

        // Method to retrieve an event, passing parameter event_id
	public static Event retrieveEvent(int event_id) {
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null; //declare an instance of ResultSet
            Event event = null;

            try {
                con = DBConnection.getInstance().getConnection();
                pstmt = con.prepareStatement(
                        "SELECT * FROM events WHERE event_id = ?");
                pstmt.setInt(1, event_id);
                rs = pstmt.executeQuery(); //execute query in database and assign retrieved data to rs
                
                while (rs.next()) {
                    EventType eventType = DBOperations.getEventTypeByName(rs.getString("event_name"));
                    Library library = getLibraryForEventType(eventType);
                    if (library != null) {
                        event = library.createEvent(eventType);
                        event.setEventID(rs.getInt("event_id"));
                        event.setEventName(rs.getString("event_name"));
                        event.setEventDescription(rs.getString("event_description"));
                        event.setEventActivities(rs.getString("event_activities"));
                        event.setAdmissionFees(rs.getDouble("admission_fees"));
                    } else {
                        throw new IllegalArgumentException("Invalid event type: " + eventType);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return event; 
        }

        // Method to update an event, passing parameter event
	public static void updateEvent(Event event) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = DBConnection.getInstance().getConnection();
                pstmt = con.prepareStatement(
                        "UPDATE events SET event_description = ?, "
                        + "event_activities = ? WHERE event_id = ?");
                pstmt.setString(1, event.getEventDescription());
                pstmt.setString(2, event.getEventActivities());
                pstmt.setInt(3, event.getEventID());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
	}

        // Method to delete an event, passing parameter event
	public static void deleteEvent(int event_id) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = DBConnection.getInstance().getConnection();
                pstmt = con.prepareStatement(
                        "DELETE FROM events WHERE event_id = ?");
                pstmt.setInt(1, event_id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
	}
        
        // Static method to return a specific type of library object based on eventType
        public static Library getLibraryForEventType(EventType eventType) {
            switch (eventType) {
                case KIDS_STORY:
                case MOVIE_NIGHT:
                    return new PublicLibrary();
                case WORKSHOP:
                case BOOK_LAUNCH:
                    return new AcademicLibrary();
                default:
                    return null;
            }
        }
        
        // Static method to return the Type of an event by event name
        public static EventType getEventTypeByName(String eventName) {
            switch (eventName) {
                case "Book Launch":
                    return EventType.BOOK_LAUNCH;
                case "Kids Story Time":
                    return EventType.KIDS_STORY;
                case "Movie Night":
                    return EventType.MOVIE_NIGHT;
                case "Workshop":
                    return EventType.WORKSHOP;          
                default:
                    return null; 
            }
    }
}
