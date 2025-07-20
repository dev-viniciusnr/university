package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class ConsultaDAO extends DAO {

    private static ConsultaDAO instance;

    private ConsultaDAO() {
        DAO.getConnection();
    }

    // Singleton
    public static ConsultaDAO getInstance() {
        if (instance == null) {
            instance = new ConsultaDAO();
        }
        return instance;
    }

// Partial CRUD    
    // Create
    public void addConsulta(Date data, String historico, Veterinario veterinario) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (data,historico,id_veterinario) VALUES (?,?,?)");
            stmt.setString(1, data.toString());
            stmt.setString(2, historico);
            stmt.setInt(3, veterinario.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            consulta = new Consulta(rs.getInt("id"), rs.getDate("data"), rs.getString("historico"), rs.getInt("id_veterinario"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

    // RetrieveAll
    public List getAllConsultas(int idAnimal) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM consulta WHERE id_animal");
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Consulta getConsultaById(int id) {
        Consulta consulta = null;
        ResultSet rs = getResultSet("SELECT * FROM consulta WHERE id = " + id);
        try {
            if (rs.next()) {
                consulta = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

    // RetrieveByName
    // Updade
    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET data=?, historico=?, veterinario=? WHERE id=?");
            stmt.setString(1, consulta.getData().toString());
            stmt.setString(2, consulta.getHistorico());
            stmt.setInt(3, consulta.getVeterinarioId());
            stmt.setInt(4, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Delete   

    public void deleteConsulta(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
