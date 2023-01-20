package com.bilgeadam.hibernate;

import com.bilgeadam.hibernate.entity.Musteri;
import com.bilgeadam.hibernate.entity.Siparis;
import com.bilgeadam.hibernate.entity.SiparisKalemi;
import com.bilgeadam.hibernate.entity.Urun;
import com.bilgeadam.hibernate.service.SiparisService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Musteri m1 = new Musteri("Ali","Kaya");
        Musteri m2 = new Musteri("Veli","Özkan");

        Urun u1 = new Urun("Iphone 11",17000);
        Urun u2 = new Urun("Samsung S21",18000);
        Urun u3 = new Urun("LG LED TV",8500);
        Urun u4 = new Urun("Arçelik Süpürge",2500);


        SiparisKalemi sk1 = new SiparisKalemi(u1,1);
        SiparisKalemi sk2 = new SiparisKalemi(u2,2);
        Siparis s1 = new Siparis(m1, Arrays.asList(sk1,sk2));

        SiparisKalemi sk3 = new SiparisKalemi(u3,2);
        SiparisKalemi sk4 = new SiparisKalemi(u4,1);
        Siparis s2 = new Siparis(m2, Arrays.asList(sk3,sk4));

        SiparisKalemi sk5 = new SiparisKalemi(u4,2);
        Siparis s3 = new Siparis(m1, Arrays.asList(sk5));

        Siparis s4 = new Siparis(m2, Arrays.asList(new SiparisKalemi(u1,1)));
        Siparis s5 = new Siparis(m2, Arrays.asList(new SiparisKalemi(u2,1)));

        SiparisService siparisService = new SiparisService();
        /*siparisService.save(s1);
        siparisService.save(s2);
        siparisService.save(s3);
        siparisService.save(s4);*/

        siparisService.Soru2_A();

    }
}
