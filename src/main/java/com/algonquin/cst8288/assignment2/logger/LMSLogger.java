package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class to create LMSLogger instance that apply Singleton pattern
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class LMSLogger {

    private static LMSLogger lmsLoggerInstance;
    private static final String LOG_FILE = "application.log";
    private static PrintWriter writer;

    // Private constructor 
    private LMSLogger() {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to ensure only one LMSLogger instance is initialized
    public static synchronized LMSLogger getInstance() {
        if (lmsLoggerInstance == null) {
            lmsLoggerInstance = new LMSLogger();
        }
        return lmsLoggerInstance;
    }

    // Method to write logs into the log file
    public void log(LogLevel level, String message) {
        writer.println("[" + level + "] " + message);
        writer.flush();
    }

    // Method to write exceptions into the log file
    public void logException(Exception e) {
        writer.println("[EXCEPTION] " + e.getMessage());
        e.printStackTrace(writer);
        writer.flush();
    }

    // Close the log file
    public void close() {
        writer.close();
    }
}