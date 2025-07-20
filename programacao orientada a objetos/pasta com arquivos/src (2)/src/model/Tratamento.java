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
    private String dataInicial;
    private String dataFinal;
    private int animalId;

    public Tratamento(int id,String dataInicial, String dataFinal,int animalId) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getAnimalId() {
        return animalId;
    }


}
