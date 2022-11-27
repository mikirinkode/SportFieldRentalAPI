package com.example.sport.service;

import com.example.sport.form.SportFieldForm;
import com.example.sport.model.SportFieldModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SportFieldSvc {
    SportFieldModel create(SportFieldForm form);
    List<SportFieldModel> getAll();
    ResponseEntity<Object> findById(Long id);
    ResponseEntity<Object> updateById(Long id, SportFieldForm form);
    ResponseEntity<Object> deleteById(Long id);
    ResponseEntity<Object> findByQuery(String keyword);
}
