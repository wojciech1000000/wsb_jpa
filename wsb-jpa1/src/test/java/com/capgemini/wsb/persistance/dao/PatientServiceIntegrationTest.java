package com.capgemini.wsb.persistance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;

@SpringBootTest
@Transactional
public class PatientServiceIntegrationTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientService patientService;


    @Test
    public void testDeletePatient() {
        PatientEntity patientEntity = patientDao.findById(1L).orElse(null);
        assertNotNull(patientEntity);

        patientService.deletePatient(patientEntity.getId());

        PatientEntity deletedPatient = patientDao.findById(patientEntity.getId()).orElse(null);
        assertEquals(null, deletedPatient);
    }

    @Test
    public void testFindById() {
        PatientEntity patientEntity = patientDao.findById(1L).orElse(null);
        assertNotNull(patientEntity);

        PatientTO patientTO = patientService.findById(patientEntity.getId());

        assertNotNull(patientTO);
        assertEquals(patientEntity.getId(), patientTO.getId());
        assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity.getLastName(), patientTO.getLastName());
    }
}
