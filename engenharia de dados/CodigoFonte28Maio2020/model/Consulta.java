package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Consulta {
    private Date data;
    private String historico;
    private Veterinario veterinario;
    private List listaDeExames;

    public Consulta(Date data, String historico, Veterinario veterinario) {
        this.data = data;
        this.historico = historico;
        this.veterinario = veterinario;
        listaDeExames = new ArrayList();
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

    public Veterinario getVeterinario() {
        return veterinario;
    }


    
    
}
