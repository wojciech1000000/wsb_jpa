package com.capgemini.wsb.persistence.dao.impl;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public interface VisitDao extends JpaRepository<VisitEntity, Long>{

    List<VisitEntity> findAllByPatientId(Long patientId);

    List<VisitEntity> findByPatientId(Long patientId);
    
}
