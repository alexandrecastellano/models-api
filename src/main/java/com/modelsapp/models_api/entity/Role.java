package com.modelsapp.models_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.modelsapp.models_api.permission.EnumPermission;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumPermission name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference // impede loops ao criar usuarios
    private List<User> users;
}
