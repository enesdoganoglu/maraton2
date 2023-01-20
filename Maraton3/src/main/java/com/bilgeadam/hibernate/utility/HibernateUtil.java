package com.bilgeadam.hibernate.utility;

import com.bilgeadam.hibernate.entity.Musteri;
import com.bilgeadam.hibernate.entity.Siparis;
import com.bilgeadam.hibernate.entity.SiparisKalemi;
import com.bilgeadam.hibernate.entity.Urun;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Musteri.class);
                configuration.addAnnotatedClass(Urun.class);
                configuration.addAnnotatedClass(SiparisKalemi.class);
                configuration.addAnnotatedClass(Siparis.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
