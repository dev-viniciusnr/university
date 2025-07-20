package model;

/**
 *
 * @author Plinio Vilela
 */
public class Veterinario {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;

    public Veterinario(int id, String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public int getId(){
        return id;
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
    
}
