package model;

/**
 *
 * @author Plinio Vilela
 */
public class Veterinario {
    private String nome;
    private String endereco;
    private String telefone;

    public Veterinario(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
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
