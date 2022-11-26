package com.example.sport.controller;

import com.example.sport.form.FieldOwnerForm;
import com.example.sport.model.FieldOwnerModel;
import com.example.sport.service.FieldOwnerSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class FieldOwnerController {

    private final FieldOwnerSvc service;

    @Autowired
    private FieldOwnerController(FieldOwnerSvc service){
        this.service = service;
    }

    @PostMapping
    public FieldOwnerModel create(@RequestBody FieldOwnerForm form){
        return service.create(form);
    }

    @GetMapping
    public List<FieldOwnerModel> getAll(){
        return service.getAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping(value = "{id}/update")
    public ResponseEntity<Object> updateById(@RequestBody FieldOwnerForm form, @PathVariable Long id){
        return service.updateById(id, form);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }

}
