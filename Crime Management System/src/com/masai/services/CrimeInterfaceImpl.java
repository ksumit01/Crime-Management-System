package com.masai.services;
import java.util.Map;

import com.masai.entities.Crime;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.InvalidDataException;
//import com.masai.exceptions.ProductException;

public class CrimeInterfaceImpl implements CrimeImp {

	
	@Override
	public String addCrime(Crime c, Map<Integer, Crime> data) throws InvalidDataException {
		
		data.put(c.getCrimeId(), c);
		return "Crime added successfully";
//		if (crimes.containsKey(crimeId)) {
//			throw new InvalidDataException("Crime ID already exists.");
//		}
//
//		if (!type.equalsIgnoreCase("Robbery") && !type.equalsIgnoreCase("Theft") && !type.equalsIgnoreCase("Homicide")) {
//			throw new InvalidDataException("Invalid crime type. Allowed types are: Robbery, Theft, Homicide.");
//		}
//
//		if (description == null || description.trim().isEmpty()) {
//			throw new InvalidDataException("Crime description cannot be empty.");
//		}
//
//		if (psArea == null || psArea.trim().isEmpty()) {
//			throw new InvalidDataException("Police station area cannot be empty.");
//		}
//
//		if (date == null) {
//			throw new InvalidDataException("Crime date cannot be empty.");
//		}
//
//		if (victimName == null || victimName.trim().isEmpty()) {
//			throw new InvalidDataException("Victim name cannot be empty.");
//		}
//
//		Crime newCrime = new Crime();
//		crimes.put(crimeId, newCrime);
		
	}

	@Override
	public String updateCrime(int id, Crime c, Map<Integer, Crime> crime) throws InvalidDataException, CrimeNotFoundException {

		if (crime != null && crime.size() > 0) {

			if (crime.containsKey(id)) {
				crime.put(id, c);
				return "Crime has successfully updated";
			} else {
				throw new CrimeNotFoundException("Crime not found");
			}

		} else {
			throw new CrimeNotFoundException("Crime list is empty");
		}

		
//		if (!crimes.containsKey(crimeId)) {
//			throw new InvalidDataException("Crime ID not found.");
//		}
//
//		Crime crimeToUpdate = crimes.get(crimeId);

//		if (type != null && !type.trim().isEmpty()) {
//			if (!type.equalsIgnoreCase("Robbery") && !type.equalsIgnoreCase("Theft") && !type.equalsIgnoreCase("Homicide")) {
//				throw new InvalidDataException("Invalid crime type. Allowed types are: Robbery, Theft, Homicide.");
//			}
//			crimeToUpdate.setType(type);
//		}
//
//		if (description != null && !description.trim().isEmpty()) {
//			crimeToUpdate.setDescription(description);
//		}
//
//		if (psArea != null && !psArea.trim().isEmpty()) {
//			crimeToUpdate.setPsArea(psArea);
//		}
//
//		if (date != null) {
//			crimeToUpdate.setDate(date);
//		}
//
//		if (victimName != null && !victimName.trim().isEmpty()) {
//			crimeToUpdate.setVictimName(victimName);
//		}
	}
//	
//	
//	@Override
//	public void assignCriminal(int criminalId, String name, LocalDate dob, String gender, String identifyingMark,
//	        LocalDate firstArrestDate, String arrestedFromPsArea) throws InvalidDataException {
//
//	    if (criminals.containsKey(criminalId)) {
//	        throw new InvalidDataException("Criminal ID already exists.");
//	    }
//
//	    if (name == null || name.trim().isEmpty()) {
//	        throw new InvalidDataException("Criminal name cannot be empty.");
//	    }
//
//	    if (dob == null) {
//	        throw new InvalidDataException("Date of birth cannot be empty.");
//	    }
//
//	    if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
//	        throw new InvalidDataException("Invalid gender. Only 'M' or 'F' is allowed.");
//	    }
//
//	    if (identifyingMark == null || identifyingMark.trim().isEmpty()) {
//	        throw new InvalidDataException("Identifying mark cannot be empty.");
//	    }
//
//	    if (firstArrestDate == null) {
//	        throw new InvalidDataException("First arrest date cannot be empty.");
//	    }
//
//	    if (arrestedFromPsArea == null || arrestedFromPsArea.trim().isEmpty()) {
//	        throw new InvalidDataException("Arrested from police station area cannot be empty.");
//	    }
//
//	    Criminal criminal = new Criminal(criminalId, name, dob, gender, identifyingMark, firstArrestDate, arrestedFromPsArea);
//	    criminals.put(criminalId, criminal);
//	}
//
//	@Override
//	public void removeCriminal(int crimeId, int criminalId) throws InvalidDataException {
//	    Crime crime = crimes.get(crimeId);
//
//	    if (crime == null) {
//	        throw new InvalidDataException("Crime not found.");
//	    }
//
//	    List<Integer> criminalIds = crime.getCrimeId();
//
//	    if (criminalIds == null || criminalIds.isEmpty()) {
//	        throw new InvalidDataException("No criminal found for this crime.");
//	    }
//
//	    if (!criminalIds.contains(criminalId)) {
//	        throw new InvalidDataException("Criminal not found for this crime.");
//	    }
//
//	    criminalIds.remove((Integer) criminalId);
//	    System.out.println("Criminal removed successfully from crime.");
//	}
//
	@Override
	public void deleteCrime(int crimeId,Map<Integer, Crime> crime) throws CrimeNotFoundException{
	    if (!crime.containsKey(crimeId)) {
	        throw new CrimeNotFoundException("Crime not found.");
	    }

	    crime.remove(crimeId);
	    System.out.println("Crime deleted successfully.");
	}
//	
//	
	@Override
	public void viewAllCrimes(Map<Integer, Crime> crimes) {
	    if (crimes.isEmpty()) {
	        System.out.println("No crimes found.");
	    } else {
	        System.out.println("All crimes:");
	        for (Map.Entry<Integer, Crime> entry : crimes.entrySet()) {
	            System.out.println(entry.getValue().toString());
	        }
	    }
	}


}

