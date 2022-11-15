package com.mualimsyahrido.simplecrud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Student {
    @Id
    private String idStudent;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}
