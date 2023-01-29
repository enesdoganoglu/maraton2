package com.bilgeadam.service;

import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.repository.SiparisRepository;
import com.bilgeadam.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class SiparisService {

    SiparisRepository siparisRepository = new SiparisRepository();
    public void save(Siparis siparis){
        siparisRepository.save(siparis);
    }
    public void soru2ASiparisleriListele(){
        List<Siparis> siparisList = siparisRepository.getAll();

        for(Siparis s:siparisList){
            int toplam = 0;
            System.out.println("Siparis ID: " + s.getId()+", Müşter Ad-Soyad: "+s.getMusteri().getName()+" "+s.getMusteri().getSurname()+" Müşteri ID: "+s.getMusteri().getId());
            for(SiparisKalemi sk : s.getSiparisKalemi()) {
                System.out.println("     Ürün Adı: "+sk.getUrun().getName()+", Fiyat: "+sk.getUrun().getPrice()+ ", Adet Sayısı: "+sk.getUrunAdedi());
                toplam = toplam + sk.getUrunAdedi() * sk.getUrun().getPrice();

            }
            System.out.println("   Sipariş Toplam : "+toplam);
        }
    }

    public void soru2c() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

            siparisList = entityManager.createNativeQuery("SELECT m.id, count(musteri_id) FROM siparis as s\n" +
                    "inner join musteri as m on s.musteri_id=m.id\n" +
                    "GROUP BY m.id").getResultList();
            for (Object[] item : siparisList) {

                System.out.println("MüşteriId: " + item[0] +  " Siparişsayısı: " + item[1] );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void soru2d() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            siparisList = entityManager.createNativeQuery(" SELECT m.name, m.surname, s.id FROM musteri as m\n" +
                    "inner join siparis as s ON m.id = s.musteri_id;").getResultList();
            for (Object[] item : siparisList) {

                System.out.println(" Müşteri Ad: " + item[0] + " Müşteri Soyad: " + item[1] + " Sipariş ID: " + item[2]);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
