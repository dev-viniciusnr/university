package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cep;
    private String email;
    private List<Animal> listaDeAnimais;

    public Cliente(int id, String nome, String endereco, String telefone, String cep) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep = cep;
        listaDeAnimais = new ArrayList();
    }
    
    public int getId(){
        return id;
    }
    
    public void addAnimal(Animal animal){
        listaDeAnimais.add(animal);
    }
    
    public List getAnimais(){
        return listaDeAnimais;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEmail() {
        return email;
    }
    
    public String toString(){
        return this.nome;
    }
    
}
