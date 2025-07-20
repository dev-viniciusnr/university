package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Tratamento {

    private int id;
    private Date dataInicial;
    private Date dataFinal;
    private List<Consulta> listaDeConsultas;
    private int animalId;

    public Tratamento(int id,Date dataInicial, Date dataFinal,int animalId) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public void addConsulta(Consulta consulta) {
        listaDeConsultas.add(consulta);
    }

    public List getConsultas() {
        return listaDeConsultas;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getAnimalId() {
        return animalId;
    }

    public List<Consulta> getListaDeConsultas() {
        return listaDeConsultas;
    }

}
