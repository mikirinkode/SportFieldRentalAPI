package com.example.sport.form;

import com.example.sport.model.FieldOwnerModel;
import lombok.Data;

@Data
public class SportFieldForm {
    private String name;
    private String description;
    private String category;
    private String address;
    private String phoneNumber;
    private FieldOwnerModel fieldOwner;
    private String open_schedule;
    private Double price;
}
