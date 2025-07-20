package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspecieDAO extends DAO {

    private static EspecieDAO instance;

    private EspecieDAO() {
        DAO.getConnection();
    }

    public static EspecieDAO getInstance() {
        if (instance == null) {
            instance = new EspecieDAO();
        }
        return instance;
    }

    public void addEspecie(String nome) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO especie (nome) VALUES (?)");
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Especie buildObject(ResultSet rs) {
        Especie especie = null;
        try {
            especie = new Especie(rs.getInt("id"),rs.getString("nome"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especie;
    }

    public List<Especie> getAllEspecies(int idCliente) {
        List<Especie> especies = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM animal WHERE id_cliente = " + idCliente);
        try {
            while (rs.next()) {
                especies.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especies;
    }

    public Especie getEspecieById(int id) {
        Especie especie = null;
        ResultSet rs = getResultSet("SELECT * FROM especie WHERE id = " + id);
        try {
            if (rs.next()) {
                especie = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especie;
    }

}
