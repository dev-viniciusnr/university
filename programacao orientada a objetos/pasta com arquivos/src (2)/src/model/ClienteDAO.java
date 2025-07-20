package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Plinio Vilela
 */
public class ClienteDAO extends DAO {

    private static ClienteDAO instance;

    private ClienteDAO() {
        DAO.getConnection();
    }

    // Singleton
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

// Partial CRUD    
    // Create
    public int addCliente(String nome, String cep, String email, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        try {
            PreparedStatement stmt;
            ResultSet linha = null;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO cliente (nome,cep,email,telefone,rua,numero,complemento,bairro,cidade,estado) VALUES (?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome);
            stmt.setString(2, cep);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, rua);
            stmt.setString(6, numero);
            stmt.setString(7, complemento);
            stmt.setString(8, bairro);
            stmt.setString(9, cidade);
            stmt.setString(10, estado);
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

    private Cliente buildObject(ResultSet rs) {
        Cliente cliente = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            cliente = new Cliente(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("cep"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    // RetrieveAll
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM cliente");
        try {
            while (rs.next()) {
                clientes.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Cliente getClienteById(int id) {
        Cliente cliente = null;
        ResultSet rs = getResultSet("SELECT * FROM cliente WHERE id = " + id);
        try {
            if (rs.next()) {
                cliente = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    // RetrieveByName
    // Updade
    public void update(Cliente cliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE cliente SET nome=?,  cep=?, email=?, telefone=? , rua=? , numero=? , complemento=? , bairro=? , cidade=? , estado=? WHERE id=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCep());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getRua());
            stmt.setString(6, cliente.getNumero());
            stmt.setString(7, cliente.getComplemento());
            stmt.setString(8, cliente.getBairro());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getEstado());
            stmt.setInt(11, cliente.getId());

            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Delete   

    public void deleteCliente(Cliente cliente) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM cliente WHERE id = ?");
            stmt.setInt(1, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
