package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Tratamento {
    private Date dataInicial;
    private Date dataFinal;
    private List listaDeConsultas;

    public Tratamento(Date dataInicial) {
        this.dataInicial = dataInicial;
        listaDeConsultas = new ArrayList();
    }
    
    public void addConsulta(Consulta consulta){
        listaDeConsultas.add(consulta);
    }
    
    public List getConsultas(){
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
    
}
