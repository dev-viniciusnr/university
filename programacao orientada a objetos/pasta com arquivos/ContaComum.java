
public class ContaComum extends Conta {

    public ContaComum(String numero, String nome) {
        super(numero, nome);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor < getSaldo()) {
            depositar(-valor);//será um depósito negativo
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ContaComum{" + super.toString() + '}';
    }

}
