package com.bilgeadam.service;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.repository.MusteriRepository;
import com.bilgeadam.repository.SiparisRepository;

import java.util.List;

public class MusteriService {
    MusteriRepository musteriRepository = new MusteriRepository();

    public void soru2BMusterileriListele(){
        List<Musteri> musteriList = musteriRepository.getAll();

        for(Musteri  m : musteriList){
            int toplam = 0;
            System.out.println("Müşteri id: " + m.getId()+"  Müşteri ad: "+m.getName()+" Müşteri soyad:  "+m.getSurname());
            for(Siparis s : m.getSiparisList()) {
                System.out.println("  Sipariş id: "+s.getId());
                for(SiparisKalemi sk : s.getSiparisKalemi()){
                    System.out.println("    Ürün: " + sk.getUrun().getName() + " Fiyat: " + sk.getUrun().getPrice() +" Adet:"+ sk.getUrunAdedi());
                    toplam = toplam + sk.getUrunAdedi() * sk.getUrun().getPrice();
                }

            }
            System.out.println(" Toplam Harcama : "+toplam);
        }
    }
}
