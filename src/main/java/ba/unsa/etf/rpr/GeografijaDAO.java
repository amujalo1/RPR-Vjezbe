package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection connection;
    private GeografijaDAO() {
        try {
            // Konektuj se na bazu podataka (SQLite)
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baza");
            Statement stmt = connection.createStatement();
            ResultSet rezultat = stmt.executeQuery("SELECT COUNT(*) FROM grad g, drzava d where g.drzava = d.glavni_grad;");
            int n = rezultat.getInt(1);
            if(n == 0)
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

    private void dodajGradUBazu(String sql, int id, String naziv, int brojStanovnika, int drzava) throws SQLException {
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
        String selectGradoviSQL = "SELECT g.naziv AS grad_naziv, g.broj_stanovnika, d.naziv AS drzava_naziv FROM grad g, drzava d WHERE g.drzava = d.id ORDER BY broj_stanovnika DESC;";

        try (PreparedStatement statement = connection.prepareStatement(selectGradoviSQL)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Grad grad = new Grad(resultSet.getString("grad_naziv"), resultSet.getInt("broj_stanovnika"), resultSet.getString("drzava_naziv"));
                gradovi.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gradovi;
    }
    // Dodajte novu metodu u GeografijaDAO klasu
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


}
