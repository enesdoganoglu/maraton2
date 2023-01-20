package com.bilgeadam.hibernate.repository;

import com.bilgeadam.hibernate.entity.Siparis;
import com.bilgeadam.hibernate.utility.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class SiparisDao {

    public static void save(Siparis siparis){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            session.close();
            System.out.println("Sipariş kaydedildi");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void getAll() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select s.id,m.firstname,m.lastname, u.urunAdi,u.urunFiyati,sk.alinanUrunAdedi from siparis as s\n" +
                    "inner join musteri as m on m.id = s.musteri_id\n" +
                    "inner join siparis_sipariskalemi as ss on s.id = ss.Siparis_id\n" +
                    "inner join sipariskalemi as sk on  sk.id=ss.siparisKalemiList_id\n" +
                    "inner join urun as u on u.id = sk.urun_id ";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {


               System.out.println("Sipariş ID: " + item[0] + " "
                        + " Müşteri: " + item[1] + " " + item[2]+" "
                        + "Ürün: " + item[3] + "  "
                        + " Fiyat: " + item[4] + " "
                        + " Adet Sayısı: " + item[5] + " "

                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void adSoyadSiparisID(){
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select m.firstname,m.lastname, s.id from siparis as s\n" +
                    "inner join musteri as m on m.id = s.musteri_id\n" +
                    "inner join siparis_sipariskalemi as ss on s.id = ss.Siparis_id\n" +
                    "inner join sipariskalemi as sk on  sk.id=ss.siparisKalemiList_id\n" +
                    "inner join urun as u on u.id = sk.urun_id ";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {


                System.out.println("Müşteri Ad " + item[0] + " "
                        + " Müşteri Soyad: " + item[1]
                        + "Sipariş ID: " + item[2] + "  "


                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
