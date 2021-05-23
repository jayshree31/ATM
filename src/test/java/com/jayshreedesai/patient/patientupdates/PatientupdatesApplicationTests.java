package com.jayshreedesai.patient.patientupdates;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class PatientupdatesApplicationTests {

	/*@Autowired
	PatientRepository patientRepository;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void findAlltest() {
		patientRepository.findAllByOrderByFullNameAsc();
	}
	
	@Test
	public void findByIDtest() {
		Patient patient = patientRepository.findById(3).get();
		assertNotNull(patient);
		assertEquals("Avani Gupta",patient.getFullName());
	}

	@Test
	public void showFormForUpdate() {
		Patient patient = patientRepository.findById(2).get();
		patient.setPhoneNumber("888899900");
		patientRepository.save(patient);
	}

	@Test
	public void showFormForSearch(){
		Patient patient = patientRepository.findByFullName("Avani Gupta").get();
		assertNotNull(patient);
		assertEquals("Avani Gupta",patient.getFullName());
	}*/
}
