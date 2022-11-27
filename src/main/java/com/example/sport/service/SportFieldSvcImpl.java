package com.example.sport.service;

import com.example.sport.common.ResponseUtil;
import com.example.sport.constant.AppConstant;
import com.example.sport.constant.MessageConstant;
import com.example.sport.form.FieldOwnerForm;
import com.example.sport.form.SportFieldForm;
import com.example.sport.model.FieldOwnerModel;
import com.example.sport.model.SportFieldModel;
import com.example.sport.repository.SportFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportFieldSvcImpl implements SportFieldSvc {

    private final SportFieldRepository repository;

    @Autowired
    public SportFieldSvcImpl(SportFieldRepository repository) {
        this.repository = repository;
    }

    @Override
    public SportFieldModel create(SportFieldForm form) {
        return repository.save(createObject(form));
    }

    @Override
    public List<SportFieldModel> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        try {
            Optional<SportFieldModel> opt = repository.findById(id);
            return opt.map(model -> ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.SUCCESS, model, HttpStatus.OK)).orElseGet(() -> ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseUtil.build(AppConstant.IS_ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(Long id, SportFieldForm form) {

        try {
            Optional<SportFieldModel> opt = repository.findById(id);
            if (!opt.isPresent())
                return ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            SportFieldModel object = opt.get();
            object.setName(form.getName());
            object.setDescription(form.getDescription());
            object.setCategory(form.getCategory());
            object.setAddress(form.getAddress());
            object.setPhoneNumber(form.getPhoneNumber());
            object.setOpenSchedule(form.getOpenSchedule());
            object.setPrice(form.getPrice());
            repository.save(object);
            return ResponseUtil.build(AppConstant.IS_ERROR, MessageConstant.UPDATE_SUCCESS, object, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseUtil.build(AppConstant.IS_ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id) {
        try {
            Optional<SportFieldModel> opt = repository.findById(id);
            if (!opt.isPresent()) return ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            repository.deleteById(id);
            return ResponseUtil.build(AppConstant.IS_NOT_ERROR, MessageConstant.DELETE_SUCCESS, null, HttpStatus.OK);
        } catch (Exception e){
            return ResponseUtil.build(AppConstant.IS_ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO : LATER
    @Override
    public ResponseEntity<Object> findByQuery(String keyword) {
        return null;
    }


    private SportFieldModel createObject(SportFieldForm form) {
        SportFieldModel object = new SportFieldModel();
        object.setName(form.getName());
        object.setDescription(form.getDescription());
        object.setCategory(form.getCategory());
        object.setAddress(form.getAddress());
        object.setPhoneNumber(form.getPhoneNumber());
        object.setOpenSchedule(form.getOpenSchedule());
        object.setPrice(form.getPrice());
        return object;
    }
}
