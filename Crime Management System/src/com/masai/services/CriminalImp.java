package com.masai.services;

import java.util.Map;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.CrimeNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;
import com.masai.exceptions.InvalidDataException;

public class CriminalImp implements CriminalIm{

	@Override
	public String addCriminals(Criminal c, Map<Integer, Criminal> data) throws InvalidDataException, CrimeNotFoundException {
		// TODO Auto-generated method stub
		data.put(c.getCriminal_id(), c);
		
		return "Criminal added successfully";
	}

//	@Override
//	public String updateCriminal(int id, Criminal c, Map<Integer, Crime> criminal)
//			throws InvalidDataException, CriminalNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String assignCriminal(int id, Map<Integer, Crime> criminal, Map<Integer, Crime> crime)
//			throws CriminalNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String removeCriminal(int id, Map<Integer, Crime> criminal) throws CriminalNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deleteCriminal(int id, Map<Integer, Crime> criminal) throws CriminalNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
