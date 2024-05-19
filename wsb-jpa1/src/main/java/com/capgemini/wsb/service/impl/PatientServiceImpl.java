package com.capgemini.wsb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.impl.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    private final VisitDao visitDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao, VisitDao visitDao) {
        this.patientDao = patientDao;
        this.visitDao = visitDao;
    }

    @Override
    public PatientTO findById(Long id) {
        PatientEntity patientEntity = patientDao.findById(id).orElse(null);
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    public void deletePatient(Long id) {
        patientDao.deleteById(id);
    }

    @Override
    public void deletePatientVisits(Long id) {
        patientDao.deletePatientVisits(id);
    }

    @Override
    public List<VisitEntity> findAllVisitsByPatientId(Long patientId) {
        return visitDao.findAllByPatientId(patientId);
    }
}
