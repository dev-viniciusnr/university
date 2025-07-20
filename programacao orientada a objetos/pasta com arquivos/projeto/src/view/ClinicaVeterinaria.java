/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import controller.Controller;
import java.util.List;
import model.Animal;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author vilela
 */
public class ClinicaVeterinaria {

//    Scanner in = new Scanner(System.in);
//
//    public void listaClientes() {
//        List<Cliente> clientes = Controller.getAllClientes();
//        for (Cliente cliente : clientes) {
//            System.out.println(cliente.getId() + " - " + cliente.getNome());
//        }
//    }
//    private void listaAnimal(){
//        listaClientes();
//        System.out.println("Selecione o id do Cliente");
//        Cliente cliente = ClienteDAO.getInstance().getClienteById(in.nextInt());
//        listaAnimal(cliente);
//    }
//    
//    public void listaAnimal(Cliente cliente) {
//        List<Animal> animals = Controller.getAllAnimal(cliente.getId());
//        for (Animal animal : animals) {
//            System.out.println(animal.getId() + " - " + animal.getNome());
//        }
//    }
//
//    private void addCliente() {
//        System.out.println("Digite o nome:");
//        String nome = in.next();
//        System.out.println("Digite o endereço:");
//        String endereco = in.next();
//        System.out.println("Digite o e-mail:");
//        String email = in.next();
//        System.out.println("Digite o telefone:");
//        String telefone = in.next();
//        System.out.println("Digite o cep:");
//        String cep = in.next();
//        Controller.addCliente(nome, endereco,email, telefone, cep);
//    }
//    
//    private void addAnimal() {
//        System.out.println("Escolha o dono");
//        listaClientes();
//        Cliente cliente = ClienteDAO.getInstance().getClienteById(in.nextInt());
//        System.out.println("Digite o nome:");
//        String nome = in.next();
//        System.out.println("Digite o ano de nascimento:");
//        int ano = in.nextInt();
//        System.out.println("Escolha o sexo:");
//        System.out.println("0 - Macho");
//        System.out.println("1 - Fêmea");
//        String sexo = in.nextInt() == 0 ? "Macho" : "Femea";
//        Controller.addAnimal(nome, ano, sexo,  cliente.getId());
//    }
//
//    public void menuPrincipal() {
//        
//        Scanner in = new Scanner(System.in);
//        while (true) {
//            System.out.println("0- Encerrar");
//            System.out.println("1- Insere Cliente");
//            System.out.println("2- Lista Clientes");
//            System.out.println("3- Insere Animal");
//            System.out.println("4- Lista Animal");
//            int opcao = in.nextInt();
//            switch (opcao) {
//                case 1:
//                    addCliente();
//                    break;
//                case 2:
//                    listaClientes();
//                    break;
//                case 3:
//                    addAnimal();
//                    break;
//                case 4:
//                    listaAnimal();
//                    break;
//                case 0:
//                    return;
//            }
//        }
//    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        new ClinicaVeterinaria().menuPrincipal();
//    }

}
