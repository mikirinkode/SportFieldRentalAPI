package com.example.sport.model;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sport_field")
@NoArgsConstructor
@Data
public class SportFieldModel extends BaseDao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "field_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

//    @ManyToOne
//    @Column(name = "field_owner", nullable = false)
//    private FieldOwnerModel fieldOwner;

    @Column(name = "open_schedule", nullable = false)
    private String open_schedule;

    @Column(name = "price", nullable = false)
    private Double price;
}
