package ba.unsa.etf.rpr.lv10;

import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection connection;
    private GeografijaDAO() {
        try {
            // Konektuj se na bazu podataka (SQLite)
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ba/unsa/etf/rpr/lv10/baza");
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("DELETE FROM grad;");
            stmt.executeUpdate("DELETE FROM drzava;");

            ResultSet rezultat = stmt.executeQuery("SELECT COUNT(*) FROM grad g, drzava d where g.drzava = d.glavni_grad;");
            int n = rezultat.getInt(1);
            if (n == 0)
                popuniTabele();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static GeografijaDAO getInstance() {
        if (instance == null) {
            instance = new GeografijaDAO();
        }
        return instance;
    }
    private void popuniTabele() {
        try {
            String insertDrzavaSQL = "INSERT INTO drzava (id, naziv, glavni_grad) VALUES (?, ?, ?);";
            String insertGradSQL = "INSERT INTO grad (id, naziv, broj_stanovnika, drzava) VALUES (?, ?, ?, ?);";

            dodajDrzavuUBazu(insertDrzavaSQL, 1, "Francuska", 1);
            dodajDrzavuUBazu(insertDrzavaSQL, 2, "Velika Britanija", 2);
            dodajDrzavuUBazu(insertDrzavaSQL, 3, "Austrija", 3);

            // Gradovi
            dodajGradUBazu(insertGradSQL, 1, "Pariz", 2200000, 1);
            dodajGradUBazu(insertGradSQL, 2, "London", 8900000, 2);
            dodajGradUBazu(insertGradSQL, 3, "Beč", 1890000, 3);
            dodajGradUBazu(insertGradSQL, 4, "Manchester", 547000, 2);
            dodajGradUBazu(insertGradSQL, 5, "Graz", 280000, 3);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void dodajDrzavuUBazu(String sql, int id, String nazivDrzave, int glavniGrad) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, nazivDrzave);
            statement.setInt(3, glavniGrad);

            statement.executeUpdate();
        }
    }

    void dodajGradUBazu(String sql, int id, String naziv, int brojStanovnika, int drzava) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, naziv);
            statement.setInt(3, brojStanovnika);
            statement.setInt(4, drzava);

            statement.executeUpdate();
        }
    }
    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> gradovi = new ArrayList<>();
        String selectGradoviSQL = "SELECT g.id as id, g.naziv AS grad_naziv, g.broj_stanovnika, d.naziv AS drzava_naziv FROM grad g, drzava d WHERE g.drzava = d.id ORDER BY id;";

        try (PreparedStatement statement = connection.prepareStatement(selectGradoviSQL)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Grad grad = new Grad(resultSet.getInt("id"), resultSet.getString("grad_naziv"), resultSet.getInt("broj_stanovnika"), resultSet.getString("drzava_naziv"));
                gradovi.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gradovi;
    }
    public ArrayList<String> gradoviNazivi() {
        ArrayList<String> gradovi = new ArrayList<>();
        String selectGradoviSQL = "SELECT naziv AS grad_naziv FROM grad;";

        try (PreparedStatement statement = connection.prepareStatement(selectGradoviSQL)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String naziv = new String(resultSet.getString("grad_naziv"));
                gradovi.add(naziv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gradovi;
    }

    public ArrayList<String> drzaveNazivi() {
        ArrayList<String> drzave = new ArrayList<>();
        String selectGradoviSQL = "SELECT naziv AS drzava_naziv FROM drzava;";

        try (PreparedStatement statement = connection.prepareStatement(selectGradoviSQL)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String naziv = new String(resultSet.getString("drzava_naziv"));
                drzave.add(naziv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drzave;
    }

    public void obrisiDrzavu(String drzava) {
        String deleteGradoviSQL = "DELETE FROM grad WHERE drzava IN (SELECT id FROM drzava WHERE naziv = ?);";
        String deleteDrzavaSQL = "DELETE FROM drzava WHERE naziv = ?;";

        try (PreparedStatement deleteGradoviStatement = connection.prepareStatement(deleteGradoviSQL);
             PreparedStatement deleteDrzavaStatement = connection.prepareStatement(deleteDrzavaSQL)) {

            deleteGradoviStatement.setString(1, drzava);
            deleteGradoviStatement.executeUpdate();

            deleteDrzavaStatement.setString(1, drzava);
            deleteDrzavaStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String glavniGrad(String nazivDrzave) {
        String selectGlavniGradSQL = "SELECT g.naziv FROM grad g, drzava d WHERE g.drzava = d.id AND d.naziv = ? AND d.glavni_grad = g.id;";

        try (PreparedStatement statement = connection.prepareStatement(selectGlavniGradSQL)) {
            statement.setString(1, nazivDrzave);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("naziv");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Vrati null ako država nije pronađena
    }
    public void dodajGrad(Grad grad) {
        String insertGradSQL = "INSERT INTO grad (id, naziv, broj_stanovnika, drzava) VALUES (?, ?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(insertGradSQL)) {
            statement.setInt(1, grad.getId());
            statement.setString(2, grad.getNaziv());
            statement.setInt(3, grad.getBrojStanovnika());
            statement.setString(4, grad.getDrzava());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajDrzavu(Drzava drzava) {
        String insertDrzavaSQL = "INSERT INTO drzava (id, naziv, glavni_grad) VALUES (?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(insertDrzavaSQL)) {
            statement.setString(1, String.valueOf(drzava.getId()));
            statement.setString(2, drzava.getNaziv());
            statement.setString(3, drzava.getGlavniGrad());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Metoda koja ažurira pripadajući red u bazi podataka za dati grad
    public void izmijeniGrad(Grad grad) {
        int idDrzave = GeografijaDAO.getInstance().nadjiDrzavu(grad.getDrzava()).getId();
        String updateGradSQL = "UPDATE grad SET naziv = ?, broj_stanovnika = ?, drzava = ? WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(updateGradSQL)) {
            statement.setString(1, grad.getNaziv());
            statement.setInt(2, grad.getBrojStanovnika());
            statement.setInt(3, idDrzave);
            statement.setString(4, String.valueOf(grad.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Drzava nadjiDrzavu(String drzava) {
        String selectDrzavaSQL = "SELECT id, naziv, glavni_grad FROM drzava WHERE naziv = ?;";

        try (PreparedStatement statement = connection.prepareStatement(selectDrzavaSQL)) {
            statement.setString(1, drzava);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Drzava(resultSet.getInt("id"),resultSet.getString("naziv"), resultSet.getString("glavni_grad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void obrisiGrad(Grad grad) {
        String deleteGradSQL = "DELETE FROM grad WHERE naziv = ?;";

        try (PreparedStatement deleteGradStatement = connection.prepareStatement(deleteGradSQL)) {
            deleteGradStatement.setString(1, grad.getNaziv());
            deleteGradStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int brojGradova() {
        String countGradoviSQL = "SELECT COUNT(*) FROM grad;";
        int brojGradova = 0;

        try (PreparedStatement statement = connection.prepareStatement(countGradoviSQL)) {
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                brojGradova = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brojGradova;
    }

    public int brojDrzava() {
        String countDrzaveSQL = "SELECT COUNT(*) FROM drzava;";
        int brojDrzava = 0;

        try (PreparedStatement statement = connection.prepareStatement(countDrzaveSQL)) {
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                brojDrzava = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brojDrzava;
    }
}
