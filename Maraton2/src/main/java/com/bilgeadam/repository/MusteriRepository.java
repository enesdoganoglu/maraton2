package com.bilgeadam.repository;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MusteriRepository {
    public List<Musteri> getAll() {

        List<Musteri> list = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            list = session.createQuery("select musteri from Musteri musteri").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
