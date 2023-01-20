package com.bilgeadam.hibernate.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String urunAdi;

    private Integer urunFiyati;

    public Urun(String urunAdi, Integer urunFiyati) {
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
    }
}
