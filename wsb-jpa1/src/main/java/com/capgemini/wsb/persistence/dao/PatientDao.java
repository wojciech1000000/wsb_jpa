package com.capgemini.wsb.persistence.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public interface PatientDao extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findByLastName(String lastName);


    List<PatientEntity> findPatientsWithMoreThanXVisits(@Param("visitCount") Integer visitCount);

    
  @Query(value = "SELECT * FROM PATIENT WHERE age > :age", nativeQuery = true)
    List<PatientEntity> findByAgeGreaterThan(@Param("age") int age);


    void deletePatientVisits(@Param("patientId") Long patientId);

    
}
