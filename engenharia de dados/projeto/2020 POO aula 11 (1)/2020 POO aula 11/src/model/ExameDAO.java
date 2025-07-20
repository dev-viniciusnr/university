package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Plinio Vilela
 */
public class ExameDAO extends DAO {

    private static ExameDAO instance;

    private ExameDAO() {
        DAO.getConnection();
    }

    // Singleton
    public static ExameDAO getInstance() {
        if (instance == null) {
            instance = new ExameDAO();
        }
        return instance;
    }

// Partial CRUD    
    // Create
    public void addExame(int idConsulta, String descricao) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO exame (id_consulta,descricao) VALUES (?, ?)");
            stmt.setInt(1, idConsulta);
            stmt.setString(2, descricao);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Exame buildObject(ResultSet rs) {
        Exame exame = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            exame = new Exame(rs.getInt("id"), rs.getString("descricao"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exame;
    }

    // RetrieveAll
    public List<Exame> getAllExames(int idConsulta) {
        List<Exame> exames = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM exame WHERE id_consulta = ?", idConsulta);

        try {
            while (rs.next()) {
                exames.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exames;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Exame getExameById(int id) {
        Exame exame = null;
        ResultSet rs = getResultSet("SELECT * FROM exame WHERE id = " + id);
        try {
            if (rs.next()) {
                exame = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exame;
    }

    // RetrieveByName
    // Updade
    public void update(Exame exame) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE exame SET descricao = ? WHERE id = ?");
            stmt.setString(1, exame.getDescricao());
            stmt.setInt(2, exame.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Delete   

    public void deleteExame(Exame exame) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM exame WHERE id = ?");
            stmt.setInt(1, exame.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
