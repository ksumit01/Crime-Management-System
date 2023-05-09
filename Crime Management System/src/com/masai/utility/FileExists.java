package com.masai.utility;

//package com.masai.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;

//import java.io.File;

//import com.masai.entities.Customer;
//import com.masai.entities.Product;

public class FileExists {


    // File paths for storing data
	public static Map<Integer, Crime> crimeFile() {

		Map<Integer, Crime> pFile = null;

		File f = new File("Crime.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {

				pFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(pFile);
				return pFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				pFile = (Map<Integer, Crime>) ois.readObject();

				return pFile;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return pFile;
	}
    /**
     * Checks if the crime data file exists, and returns a map of crime objects.
     * If the file does not exist, creates a new empty file and returns an empty map.
     *
     * @return A map of crime objects, with crime ID as the key.
     */
	public static Map<Integer, Criminal> criminalFile() {

		Map<Integer, Criminal> cFile = null;

		File f = new File("Criminal.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {
				
				cFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(cFile);
				return cFile;

			} else {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				cFile = (Map<Integer, Criminal>) ois.readObject();

				return cFile;

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
		return cFile;

	}

    
//    public static Map<Integer, Admin> getAdminData() {
//        Map<Integer, Admin> adminMap = null;
//        File file = new File(ADMIN_FILE_PATH);
//
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//                adminMap = new LinkedHashMap<>();
//                saveDataToFile(ADMIN_FILE_PATH, adminMap);
//            } else {
//                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//                adminMap = (Map<Integer, Admin>) ois.readObject();
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        return adminMap;
//    }
//
//    public static void saveAdminData(Map<Integer, Admin> adminMap) {
//        saveDataToFile(ADMIN_FILE_PATH, adminMap);
//    }


    /**
     * Saves the given map of data to the specified file.
     *
     * @param filePath The path to the file to save the data to.
     * @param data     The map of data to be saved.
     */
//    public static void saveDataToFile(String filePath, Map<?, ?> data) {
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
//            oos.writeObject(data);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }

}

