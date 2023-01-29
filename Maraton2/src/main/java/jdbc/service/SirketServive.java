package jdbc.service;

import jdbc.entity.Sirket;
import jdbc.repository.ICRUD;
import jdbc.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SirketServive implements ICRUD<Sirket> {

    DB db = new DB();
    Sirket sirket;
    List<Object> ls = new ArrayList<>();


    @Override
    public void getAll() {

        try {
            PreparedStatement stProduct = db.connection.prepareStatement(
                    "select s.id,s.sirket_ismi,s.sirket_unvani,s.sirket_sahibi,s.faaliyet_alani,s.kurulus_yili from sirketler as s ");
            ResultSet rs = stProduct.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String sirket_ismi = rs.getString("sirket_ismi");
                String sirket_unvani = rs.getString("sirket_unvani");
                String sirket_sahibi = rs.getString("sirket_sahibi");
                String faaliyet_alani = rs.getString("faaliyet_alani");
                Integer kurulus_yili = rs.getInt("kurulus_yili");

                sirket = new Sirket(id,sirket_ismi,sirket_unvani,sirket_sahibi,faaliyet_alani,kurulus_yili);
                ls.add(sirket);
            }
            if (ls.isEmpty()) {
                System.out.println("Sirket is empty");
            } else {
                ls.forEach(item -> System.out.println(item));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Sirket sirket) {
        try {

            PreparedStatement insertStatement = db.connection.prepareStatement(
                    "insert into sirketler(sirket_ismi,sirket_unvani,sirket_sahibi,faaliyet_alani,kurulus_yili )" +
                            "values(?,?,?,?,?)");

            insertStatement.setString(1, sirket.getSirket_ismi());
            insertStatement.setString(2, sirket.getSirket_unvani());
            insertStatement.setString(3, sirket.getSirket_sahibi());
            insertStatement.setString(4, sirket.getFaaliyet_alani());
            insertStatement.setInt(5, sirket.getKurulus_yili());
            insertStatement.executeUpdate();
            System.out.println("Sirket is added");
            getAll();

            insertStatement.close();
            db.connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Sirket sirket) {
        try {
            PreparedStatement list = db.connection.prepareStatement("select id from sirketler");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("id"));
            }
            if (ls.contains(sirket.getId())) {

                PreparedStatement updateStatement = db.connection.prepareStatement(
                        "update sirketler set sirket_ismi=?, sirket_unvani=?, sirket_sahibi=?, faaliyet_alani=?, kurulus_yili=? where id=?");

                updateStatement.setString(1, sirket.getSirket_ismi());
                updateStatement.setString(2, sirket.getSirket_unvani());
                updateStatement.setString(3, sirket.getSirket_sahibi());
                updateStatement.setString(4, sirket.getFaaliyet_alani());
                updateStatement.setInt(5, sirket.getKurulus_yili());
                updateStatement.setInt(6, sirket.getId());
                updateStatement.executeUpdate();

                System.out.println("Sirket is updated");
                getAll();
                updateStatement.close();
            }else {
                System.out.println("Sirket is not found");
            }
            db.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void saveAll(List<Sirket> t) {

    }

    @Override
    public void delete(int sirketId) {
        try {
            PreparedStatement list = db.connection.prepareStatement("SELECT id FROM sirketler");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("id"));
            }
            if (ls.contains(sirketId)) {
                PreparedStatement deleteStatement = db.connection.prepareStatement("DELETE FROM sirketler WHERE id = ?");
                deleteStatement.setInt(1, sirketId);
                deleteStatement.executeUpdate();
                getAll();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getById(int t) {

    }
}
