package com.masai.services;

import java.time.LocalDate;
import java.util.Map;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.InvalidDataException;

public interface CrimeImp {
    String addCrime(Crime c, Map<Integer, Crime> crime) throws InvalidDataException;
    
    String updateCrime(int id,Crime c, Map<Integer, Crime> crime) throws InvalidDataException, CrimeNotFoundException;
//    void updateCrime(int crimeId, String type, String description, String psArea, LocalDate date, String victimName) throws InvalidDataException;
////    void assignCriminal(int crimeId, int criminalId) throws InvalidDataException;
//    void removeCriminal(int crimeId, int criminalId) throws InvalidDataException;
    void deleteCrime(int crimeId,Map<Integer, Crime> crime) throws CrimeNotFoundException;
//	void assignCriminal(int criminalId, String name, LocalDate dob, String gender, String identifyingMark,
//			LocalDate firstArrestDate, String arrestedFromPsArea) throws InvalidDataException;
////	void viewAllCrimes();
	void viewAllCrimes(Map<Integer, Crime> crimes);

	
}
