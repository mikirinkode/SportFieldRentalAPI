package com.example.sport.service;

import com.example.sport.common.ResponseUtil;
import com.example.sport.constant.AppConstant;
import com.example.sport.constant.MessageConstant;
import com.example.sport.form.FieldOwnerForm;
import com.example.sport.model.FieldOwnerModel;
import com.example.sport.repository.FieldOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldOwnerSvcImpl implements FieldOwnerSvc {

    private final FieldOwnerRepository repository;

    @Autowired
    public FieldOwnerSvcImpl(FieldOwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public FieldOwnerModel create(FieldOwnerForm form) {
        return repository.save(createObject(form));
    }

    @Override
    public List<FieldOwnerModel> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        try {
            Optional<FieldOwnerModel> opt = repository.findById(id);
            return opt.map(model -> ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.SUCCESS, model, HttpStatus.OK)).orElseGet(() -> ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseUtil.build(AppConstant.IS_ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(Long id, FieldOwnerForm form) {
        try {
            Optional<FieldOwnerModel> opt = repository.findById(id);
            if (!opt.isPresent()) return ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            FieldOwnerModel owner = opt.get();
            owner.setEmail(form.getEmail());
            owner.setName(form.getName());
            repository.save(owner);
            return ResponseUtil.build(AppConstant.IS_ERROR, MessageConstant.UPDATE_SUCCESS , owner, HttpStatus.OK);

        } catch (Exception e){
            return ResponseUtil.build(AppConstant.IS_ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id) {
        try {
            Optional<FieldOwnerModel> opt = repository.findById(id);
            if (!opt.isPresent()) return ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            repository.deleteById(id);
            return ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DELETE_SUCCESS, null, HttpStatus.OK);
        } catch (Exception e){
            return ResponseUtil.build(AppConstant.IS_ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // TODO: LATER
    @Override
    public ResponseEntity<Object> findByQuery(String keyword) {
        return null;
    }

    private FieldOwnerModel createObject(FieldOwnerForm form) {
        FieldOwnerModel owner = new FieldOwnerModel();
        owner.setName(form.getName());
        owner.setEmail(form.getEmail());
        return owner;
    }
}
