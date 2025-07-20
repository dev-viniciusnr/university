package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Plinio Vilela - prvilela@unicamp.br
 * @date April 13, 2020
 */
public class VeterinarioDAO extends DAO {

    private static VeterinarioDAO instance;

    private VeterinarioDAO() {
        DAO.getConnection();
    }

    public static VeterinarioDAO getInstance() {
        if (instance == null) {
            instance = new VeterinarioDAO();
        }
        return instance;
    }

    // CRUD
    public void create(String nome, String endereco, String telefone) {
        PreparedStatement stmt;
        try {
            int newId = getLastId() + 1;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO veterinario (id, nome, endereco, telefone) VALUES (?,?,?,?)");
            stmt.setInt(1, newId);
            stmt.setString(2, nome);
            stmt.setString(3, endereco);
            stmt.setString(4, telefone);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Veterinario buildObject(ResultSet rs) {
        Veterinario veterinario = null;
        try {
            veterinario = new Veterinario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinario;
    }

    public Veterinario retrieveById(int id) {
        Veterinario result = null;
        ResultSet rs = null;
        rs = getResultSet("SELECT * FROM veterinario WHERE id=" + id);
        try {
            if (rs.next()) {
                result = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Veterinario> retrieveAll() {
        ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();
        ResultSet rs = null;
        rs = getResultSet("SELECT * FROM veterinario");
        try {
            while (rs.next()) {
                veterinarios.add(buildObject(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarios;
    }

    public Veterinario retrieveByName(String name) {
        Veterinario result = null;
        ResultSet rs = null;
        rs = getResultSet("SELECT * FROM veterinario WHERE nome='" + name + "'");
        try {
            if (rs.next()) {
                result = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Veterinario paciente) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("UPDATE veterinario SET nome=?, endereco=?, telefone=? WHERE id = ?");
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getEndereco());
            stmt.setString(3, paciente.getTelefone());
            stmt.setInt(4, paciente.getId());
            int update = executeUpdate(stmt);
            if (update == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void delete(Veterinario veterinario) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM veterinario WHERE id = ?");
            stmt.setInt(1, veterinario.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getLastId() {
        return lastId("veterinario", "id");
    }
}//PacienteDAO

