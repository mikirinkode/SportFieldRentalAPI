package com.example.sport.service;

import com.example.sport.form.FieldOwnerForm;
import com.example.sport.model.FieldOwnerModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FieldOwnerSvc {
    FieldOwnerModel create(FieldOwnerForm form);
    List<FieldOwnerModel> getAll();
    ResponseEntity<Object> findById(Long id);
    ResponseEntity<Object> updateById(Long id, FieldOwnerForm form);
    ResponseEntity<Object> deleteById(Long id);
    ResponseEntity<Object> findByQuery(String keyword);
}
