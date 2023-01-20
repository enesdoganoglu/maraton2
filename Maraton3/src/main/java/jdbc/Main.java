package jdbc;

import jdbc.entity.Calisan;
import jdbc.entity.Sirket;
import jdbc.service.CalisanService;

public class Main {

    public static void main(String[] args) {
        CalisanService calisanService = new CalisanService();

        Sirket sirket = new Sirket(1,"THY");
        Calisan calisan1 = new Calisan(1,sirket,"ali",25,15000,"Genel müdürlük");
        calisanService.save(calisan1);
    }
}
