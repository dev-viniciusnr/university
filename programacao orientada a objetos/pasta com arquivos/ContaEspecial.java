
public class ContaEspecial extends Conta {

    private double limite;//limite de crédito

    public ContaEspecial(String numero, String nome, double limite) {
        super(numero, nome);
        setLimite(limite);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor < (getSaldo() + getLimite())) {//saldo pode ficar negativo
            depositar(-valor);//será um depósito negativo
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "ContaEspecial{" + super.toString() + ", limite=" + limite + '}';
    }

}
