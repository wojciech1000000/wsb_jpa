package com.capgemini.wsb.persistance.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.impl.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;

@SpringBootTest
@Transactional
public class JPQLTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private PatientService patientService;


    @Test
    public void testFindByLastName() {
        List<PatientEntity> patients = patientDao.findByLastName("Kowalski");
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        assertEquals("Kowalski", patients.get(0).getLastName());
    }

    @Test
    public void testFindAllVisitsByPatientId() {
        Long patientId = 1L;
        List<VisitEntity> visits = patientService.findAllVisitsByPatientId(patientId);
        assertNotNull(visits);
        assertFalse(visits.isEmpty());
        assertEquals(patientId, visits.get(0).getPatient().getId());
    }

    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        int visitCount = 2;
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(visitCount);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        assertTrue(patients.stream().allMatch(patient -> {
            List<VisitEntity> visits = visitDao.findAllByPatientId(patient.getId());
            return visits.size() > visitCount;
        }));
    }


    @Test
    public void testFindPatientsByAgeGreaterThan() {
        int age = 20;
        List<PatientEntity> patients = patientDao.findByAgeGreaterThan(age);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        assertTrue(patients.stream().allMatch(patient -> patient.getAge() > age));
    }
}
