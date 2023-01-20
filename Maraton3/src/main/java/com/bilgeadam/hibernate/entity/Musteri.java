package com.bilgeadam.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    public Musteri(Integer id) {
        this.id = id;
    }

    public Musteri(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Musteri(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
