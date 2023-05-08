package com.masai.services;import java.util.Map;

import com.masai.entities.Criminal;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.InvalidDataException;

public interface CriminalIm {
//	String addCriminals(Criminal c, Map<Integer, Crime> criminal) throws InvalidDataException;
//	String updateCriminal(int id,Criminal c, Map<Integer, Criminal> criminal) throws InvalidDataException, CriminalNotFoundException;
//	String assignCriminal(int id, Map<Integer, Criminal> criminal, Map<Integer, Crime> crime) throws CriminalNotFoundException;
//	String removeCriminal(int id, Map<Integer, Criminal> criminal) throws CriminalNotFoundException;
//	String deleteCriminal(int id, Map<Integer, Criminal> criminal) throws CriminalNotFoundException;
//	void put(int id, Criminal c);
	String addCriminals(Criminal cr, Map<Integer, Criminal> criminal) throws InvalidDataException, CrimeNotFoundException;
//	Integer getCriminal_id();
	
}
