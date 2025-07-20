package model;

/**
 *
 * @author Plinio Vilela
 */
public class Exame {
    private int id;
    private String descricao;

    public Exame(int id,String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
