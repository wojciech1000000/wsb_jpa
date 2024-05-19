package com.capgemini.wsb.persistence.dao.impl;

import java.util.Optional;

import com.capgemini.wsb.persistence.dao.Dao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public interface DoctorDao  extends Dao<DoctorEntity, Long>
{
    void deleteDoctor (Long id);

    Optional<PatientEntity> findById(Long doctorId);

}
