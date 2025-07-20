package model;

/**
 *
 * @author Plinio Vilela
 */
public class Exame {
    private int id;
    private String descricao;
    private int consultaId;

    public Exame(int id,String descricao,int consultaId) {
        this.id = id;
        this.descricao = descricao;
        this.consultaId = consultaId;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getConsultaId() {
        return consultaId;
    }
    
}
