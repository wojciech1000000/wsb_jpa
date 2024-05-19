package com.capgemini.wsb.persistence.dao.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

    @Override
    public void deleteDoctor(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteDoctor'");
    }

    @Override
    public Optional<PatientEntity> findById(Long doctorId) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
