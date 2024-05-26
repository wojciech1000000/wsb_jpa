package com.capgemini.wsb.persistence.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.capgemini.wsb.persistence.entity.PatientEntity;


//spring

public interface PatientDao extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findByLastName(String lastName);

  @Query(value = "SELECT * FROM PATIENT WHERE age > :age", nativeQuery = true)
    List<PatientEntity> findByAgeGreaterThan(@Param("age") int age);


  @Query(value = "SELECT p.* FROM Patient p WHERE (SELECT COUNT(*) FROM Visit v WHERE v.patient_id = p.id) > :X", nativeQuery = true)
  List<PatientEntity> findPatientsWithMoreThanXVisits(@Param("X") int X);


    void deletePatientVisits(@Param("patientId") Long patientId);

    
}
