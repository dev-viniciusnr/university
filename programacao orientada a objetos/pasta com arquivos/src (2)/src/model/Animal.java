package model;

public class Animal {
    
    private int id;
    private String nome;
    private int anoNasc;
    private String sexo;
    private int especieId;

    public Animal(int id,String nome, int anoNasc, String sexo, int especieId) {
        this.id = id;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.sexo = sexo;
        this.especieId = especieId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEspecieId() {
        return especieId;
    }
    
    
}
