package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Animal {
    private String nome;
    private int anoNasc;
    private Sexo sexo;
    private List<Tratamento> listaDeTratamentos;
    private Especie especie;

    public Animal(String nome, int anoNasc, Sexo sexo, Especie especie) {
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.sexo = sexo;
        this.especie = especie;
        listaDeTratamentos = new ArrayList();
    }
    
    public void addTratamento(Tratamento tratamento){
        listaDeTratamentos.add(tratamento);
    }
    
    public List getTratamentos(){
        return listaDeTratamentos;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public Sexo getSexo() {
        return sexo;
    }
    
    public Especie getEspecie(){
        return especie;
    }
    
}
