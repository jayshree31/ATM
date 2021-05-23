package com.jayshreedesai.AtmApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayshreedesai.AtmApplication.entity.Bank;
import com.jayshreedesai.AtmApplication.service.ATMService;
import com.jayshreedesai.AtmApplication.dao.ATMRepository;


@Service
public class ATMServiceImpl implements ATMService {

	private ATMRepository ATMRepository;
	
	@Autowired
	public ATMServiceImpl(ATMRepository theATMRepository) {
		ATMRepository = theATMRepository;
	}

	@Override
	public Optional<Bank> findByAccountNo(int accountNo) {
		return ATMRepository.findByAccountNo(accountNo);
	}

	@Override
	public List<Bank> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bank findByfullName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Bank theBank) {
		ATMRepository.save(theBank);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

	
	/*@Override
	public List<Patient> findAll() {
		return patientRepository.findAllByOrderByFullNameAsc();
	}

	@Override
	public Patient findById(int theId) {
		Optional<Patient> result = patientRepository.findById(theId);
		
		Patient thePatient = null;
		
		if (result.isPresent()) {
			thePatient = result.get();
		}
		else {
			// we didn't find the Patient
			throw new RuntimeException("Did not find Patient id - " + theId);
		}
		
		return thePatient;
	}

	@Override
	public void save(Patient thePatient) {
		patientRepository.save(thePatient);
	}

	@Override
	public void deleteById(int theId) {
		patientRepository.deleteById(theId);
	}

	@Override
	public Patient findByfullName(String name) {
		Optional<Patient> result = patientRepository.findByFullName(name);
		
		Patient thePatient = null;
		
		if (result.isPresent()) {
			thePatient = result.get();
		}
		else {
			// we didn't find the patient
			throw new RuntimeException("Did not find Patient with this name - " + name);
		}
		
		return thePatient;
	}

	@Override
	public Bank findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bank findByfullName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Bank thePatient) {
		// TODO Auto-generated method stub
		
	}*/

}






