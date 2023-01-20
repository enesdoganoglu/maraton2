package com.bilgeadam.hibernate.service;

import com.bilgeadam.hibernate.entity.Siparis;
import com.bilgeadam.hibernate.repository.SiparisDao;

public class SiparisService {
    static SiparisDao siparisDao = new SiparisDao();
    public  void save(Siparis siparis) {
        try {
            siparisDao.save(siparis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Soru2_A(){
        try{
            siparisDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Soru2_D(){
        try{
            siparisDao.adSoyadSiparisID();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}