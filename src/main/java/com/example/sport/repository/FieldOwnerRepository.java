package com.example.sport.repository;

import com.example.sport.model.FieldOwnerModel;
import com.example.sport.model.SportFieldModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FieldOwnerRepository extends JpaRepository<FieldOwnerModel, Long> {
}
