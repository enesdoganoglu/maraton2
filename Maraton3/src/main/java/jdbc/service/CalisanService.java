package jdbc.service;

import jdbc.entity.Calisan;
import jdbc.entity.Sirket;
import jdbc.repository.ICRUD;
import jdbc.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalisanService implements ICRUD {
    DB db = new DB();
    Calisan calisan;
    List<Object> ls = new ArrayList<>();




    @Override
    public void getAll() {

    }

    @Override
    public void save(Object o) {
        try {

            PreparedStatement insertStatement = db.connection.prepareStatement(
                    "insert into public.products(sirket_id, isim,yas,maas,depertman)" +
                            "values(?,?,?,?,?)");

            insertStatement.setInt(1, calisan.getSirket().getId());
            insertStatement.setString(2, calisan.getIsim());
            insertStatement.setInt(3, calisan.getYas());
            insertStatement.setInt(4, calisan.getMaas());
            insertStatement.setString(5, calisan.getDepartman());

            insertStatement.executeUpdate();
            System.out.println("Calisan is added");
            //getAll();

            insertStatement.close();
            db.connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void update(Object o) {
        try {
            PreparedStatement list = db.connection.prepareStatement("select id from calisanlar");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("id"));
            }
            if (ls.contains(calisan.getId())) {

                PreparedStatement updateStatement = db.connection.prepareStatement(
                        "update calisanlar set sirket_id=?, isim=?, yas= ?, maas= ?,depertman=?" +
                                "where productId = ?");

                updateStatement.setInt(1, calisan.getSirket().getId());
                updateStatement.setString(2, calisan.getIsim());
                updateStatement.setInt(3, calisan.getYas());
                updateStatement.setInt(4, calisan.getMaas());
                updateStatement.setString(5, calisan.getDepartman());
                updateStatement.executeUpdate();

                System.out.println("Çalışan is updated");
                getAll();
                updateStatement.close();
            }else {
                System.out.println("Çalışan is not found");
            }
            db.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public void saveAll(List t) {

    }

    @Override
    public void delete(int idkullanici) {
        try {
            PreparedStatement list = db.connection.prepareStatement("SELECT id FROM calisanlar");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("id"));
            }
            if (ls.contains(idkullanici)) {
                PreparedStatement deleteStatement = db.connection.prepareStatement("DELETE FROM calisanlar WHERE id=?");
                deleteStatement.setInt(1, idkullanici);
                deleteStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getById(int idkullanici) {
        try {
            PreparedStatement list = db.connection.prepareStatement("SELECT id FROM calisanlar");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("id"));
            }

            if (ls.contains(idkullanici)){
                PreparedStatement st = db.connection.prepareStatement(
                        "select c.id, s.id,s.sirket_isim,c.isim,c.yas,c.maas,c.departman from calisanlar as c\n" +
                                "inner join sirketler as s on c.sirket_id = s.id where c.id=?");
                st.setInt(1, idkullanici);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Integer id = rs.getInt("id");
                    Integer  ids = rs.getInt("id");
                    String isimsirket = rs.getString("sirket_isim");
                    String isim = rs.getString("isim");
                    Integer yas = rs.getInt("yas");
                    Integer maas = rs.getInt("maas");
                    String departman = rs.getString("departman");

                    Sirket sirket =new Sirket(ids,isimsirket);
                    calisan = new Calisan(id, sirket,  isim,  yas,  maas, departman);
                    System.out.println(calisan);
                }
                st.close();
            }
            else {
                System.out.println("Çalışan is not found");
            }
            db.connection.close();
        } catch (Exception ex) {
            System.err.println("Çalışan Error: " + ex);
        }

    }
}
