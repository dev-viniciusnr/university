package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class TratamentoDAO extends DAO {

    private static TratamentoDAO instance;

    private TratamentoDAO() {
        DAO.getConnection();
    }

    // Singleton
    public static TratamentoDAO getInstance() {
        if (instance == null) {
            instance = new TratamentoDAO();
        }
        return instance;
    }

// Partial CRUD    
    // Create
    public int addTratamento(String dataInicial, int idAnimal) {
        try {
            PreparedStatement stmt;
            ResultSet linha = null;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO tratamento (data_inicial,data_final,id_animal) VALUES (?,NULL,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, dataInicial);
            stmt.setInt(2, idAnimal);
            executeUpdate(stmt);
            
            linha = stmt.getGeneratedKeys();
            if (linha.next()) {
                return linha.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            tratamento = new Tratamento(rs.getInt("id"),rs.getDate("data_inicial"), rs.getDate("data_final"), rs.getInt("id_animal"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamento;
    }

    // RetrieveAll
    public List<Tratamento> getAllTratamentos(int idAnimal) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM tratamento WHERE id_animal = ?", idAnimal);
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamentos;
    }

    public List<Tratamento> getAllTratamentos() {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM tratamento");
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamentos;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Tratamento getTratamentoById(int id) {
        Tratamento tratamento = null;
        ResultSet rs = getResultSet("SELECT * FROM tratamento WHERE id = " + id);
        try {
            if (rs.next()) {
                tratamento = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamento;
    }

    // RetrieveByName
    // Updade
    public void update(Tratamento tratamento) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE tratamento SET dataInicial=?, dataFinal=?, idConsulta=? WHERE id=?");
            stmt.setDate(1, (java.sql.Date) tratamento.getDataInicial());
            stmt.setDate(2, (java.sql.Date) tratamento.getDataFinal());
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Delete   

    public void deleteTratamento(Tratamento tratamento) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM tratamento WHERE id = ?");
            stmt.setInt(1, 0);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
