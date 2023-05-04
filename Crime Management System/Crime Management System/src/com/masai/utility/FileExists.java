package com.masai.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileExists {


    // File paths for storing data
    private static final String CRIMINAL_FILE_PATH = "criminals.ser";
    private static final String CRIME_FILE_PATH = "crimes.ser";

    /**
     * Checks if the criminal data file exists, and returns a map of criminal objects.
     * If the file does not exist, creates a new empty file and returns an empty map.
     *
     * @return A map of criminal objects, with criminal ID as the key.
     */
    public static Map<Integer, Criminal> getCriminalData() {
        Map<Integer, Criminal> criminalMap = null;
        File file = new File(CRIMINAL_FILE_PATH);

        try {
            if (!file.exists()) {
                file.createNewFile();
                criminalMap = new LinkedHashMap<>();
                saveDataToFile(CRIMINAL_FILE_PATH, criminalMap);
            } else {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                criminalMap = (Map<Integer, Criminal>) ois.readObject();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return criminalMap;
    }

    /**
     * Checks if the crime data file exists, and returns a map of crime objects.
     * If the file does not exist, creates a new empty file and returns an empty map.
     *
     * @return A map of crime objects, with crime ID as the key.
     */
    public static Map<Integer, Crime> getCrimeData() {
        Map<Integer, Crime> crimeMap = null;
        File file = new File(CRIME_FILE_PATH);

        try {
            if (!file.exists()) {
                file.createNewFile();
                crimeMap = new LinkedHashMap<>();
                saveDataToFile(CRIME_FILE_PATH, crimeMap);
            } else {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                crimeMap = (Map<Integer, Crime>) ois.readObject();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return crimeMap;
    }

    /**
     * Saves the given map of data to the specified file.
     *
     * @param filePath The path to the file to save the data to.
     * @param data     The map of data to be saved.
     */
    public static void saveDataToFile(String filePath, Map<?, ?> data) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(data);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

