package com.capgemini.wsb.persistence.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;

@SuppressWarnings("unchecked")
@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findAll(Sort sort) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p", PatientEntity.class)
                            .getResultList();
    }
    
    @Override
    public List<PatientEntity> findAllById(Iterable<Long> ids) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.id IN :ids", PatientEntity.class)
                            .setParameter("ids", ids)
                            .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(Integer visitCount) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.visitCount > :visitCount", PatientEntity.class)
                            .setParameter("visitCount", visitCount)
                            .getResultList();
    }
    
    @Override
    public <S extends PatientEntity> List<S> saveAll(Iterable<S> entities) {
        for (S entity : entities) {
            save(entity);
        }
        return (List<S>) entities;
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public <S extends PatientEntity> S saveAndFlush(S entity) {
        save(entity);
        flush();
        return entity;
    }

    @Override
    public void deleteInBatch(Iterable<PatientEntity> entities) {
        for (PatientEntity entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAllInBatch() {
        entityManager.createQuery("DELETE FROM PatientEntity").executeUpdate();
    }

    @Override
    public <S extends PatientEntity> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends PatientEntity> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<PatientEntity> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<PatientEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(PatientEntity.class, id));
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public void deleteAll(Iterable<? extends PatientEntity> entities) {
        for (PatientEntity entity : entities) {
            delete(entity);
        }
    }

    @Override
    public <S extends PatientEntity> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public <S extends PatientEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends PatientEntity> long count(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends PatientEntity> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                            .setParameter("lastName", lastName)
                            .getResultList();
    }

    @Override
    public List<PatientEntity> findByAgeGreaterThan(int age) {
        throw new UnsupportedOperationException("Unimplemented method 'findByAgeGreaterThan'");
    }

    @Override
    public void deletePatientVisits(Long patientId) {
        throw new UnsupportedOperationException("Unimplemented method 'deletePatientVisits'");
    }
    
}
