package com.example.sport.controller;

import com.example.sport.form.FieldOwnerForm;
import com.example.sport.form.SportFieldForm;
import com.example.sport.model.FieldOwnerModel;
import com.example.sport.model.SportFieldModel;
import com.example.sport.service.FieldOwnerSvc;
import com.example.sport.service.SportFieldSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field")
public class SportFieldController {

    private final SportFieldSvc service;

    @Autowired
    public SportFieldController(SportFieldSvc service) {
        this.service = service;
    }

    @PostMapping
    public SportFieldModel create(@RequestBody SportFieldForm form){
        return service.create(form);
    }

    @GetMapping
    public List<SportFieldModel> getAll(){
        return service.getAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping(value = "{id}/update")
    public ResponseEntity<Object> updateById(@RequestBody SportFieldForm form, @PathVariable Long id){
        return service.updateById(id, form);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }
}
