package com.example.sport.model;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "field_owner")
@NoArgsConstructor
@Data
public class FieldOwnerModel extends BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

//    @OneToMany
//    @Column(name = "field_list", nullable = true)
//    private List<SportFieldModel> sportFieldList;


}
