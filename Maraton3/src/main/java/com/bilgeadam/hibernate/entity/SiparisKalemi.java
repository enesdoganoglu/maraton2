package com.bilgeadam.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Urun urun;

    private Integer alinanUrunAdedi;

    public SiparisKalemi(Urun urun, Integer alinanUrunAdedi) {
        this.urun = urun;
        this.alinanUrunAdedi = alinanUrunAdedi;
    }
}
