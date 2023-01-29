package jdbc;

import jdbc.entity.Calisan;
import jdbc.entity.Sirket;
import jdbc.service.CalisanService;
import jdbc.service.SirketServive;

public class Main {

    public static void main(String[] args) {
        CalisanService calisanService = new CalisanService();

        Sirket sirket = new Sirket(5,"Türk Telekom");
        Calisan calisan1 = new Calisan(1,sirket,"Furkan",25,16000,"Genel müdürlük");
        //calisanService.save(calisan1);

        SirketServive sirketServive = new SirketServive();

        Sirket sirket1 = new Sirket("THY","TURK HAVA YOLLARI A.O.","Devlet","Havacılık",1933);
        //sirketServive.save(sirket1);

        Sirket sirket2 = new Sirket(5,"Türk Telekom","TÜRK TELEKOMÜNİKASYON A.Ş.","Devlet","Haberleşme",1995);
        //sirketServive.save(sirket2);

        Calisan calisan2 = new Calisan(sirket2,"ali",25,15000,"Genel müdürlük");
        //calisanService.save(calisan2);


        Sirket sirket3 = new Sirket(9,"FORD OTOMOTİV","Ford Otomotiv Sanayi A.Ş.","Koç Holding","Otomotiv",1959);
        //sirketServive.save(sirket3);
        //sirketServive.getAll();
        //sirketServive.delete(10);
        //sirketServive.getAll();
        //sirketServive.update(sirket2);
        //calisanService.getAll();
        //calisanService.delete(2);
        calisanService.update(calisan1);

    }
}
