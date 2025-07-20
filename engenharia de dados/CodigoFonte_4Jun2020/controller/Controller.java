package controller;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Plinio Vilela
 */
public class Controller {
    
    public static void addCliente(String nome, String endereco, String email, String telefone, String cep){
        ClienteDAO.getInstance().addCliente(nome, endereco, email, telefone, cep);
    }
    
    public static List getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
    
    public static Cliente getClienteById(int id){
        return ClienteDAO.getInstance().getClienteById(id);
    }
    
    public static void deleteCliente(Cliente cliente){
        ClienteDAO.getInstance().deleteCliente(cliente);
    }
}
