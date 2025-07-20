package model;

import java.sql.Date;

/**
 *
 * @author Plinio Vilela
 */
public class Consulta {
    
    private int id;
    private Date data;
    private String historico;
    private int veterinarioId;
    private int animalId;

    public Consulta(int id, Date data, String historico, int veterinarioId, int animalId) {
        this.id = id;
        this.data = data;
        this.historico = historico;
        this.veterinarioId = veterinarioId;
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getHistorico() {
        return historico;
    }

    public int getVeterinarioId() {
        return veterinarioId;
    }

    public int getAnimalId() {
        return animalId;
    }
}
