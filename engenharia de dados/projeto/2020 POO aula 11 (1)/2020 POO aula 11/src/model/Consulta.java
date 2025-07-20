package model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Consulta {
    
    private int id;
    private Date data;
    private String historico;
    private int veterinarioId;
    private List<Exame> listaDeExames;

    public Consulta(int id, Date data, String historico, int veterinarioId) {
        this.id = id;
        this.data = data;
        this.historico = historico;
        this.veterinarioId = veterinarioId;
        listaDeExames = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void addExame(Exame exame){
        listaDeExames.add(exame);
    }
    
    public List getListaDeExames() {
        return listaDeExames;
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
}
