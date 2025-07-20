
public abstract class Conta {

    private String numero;//numero da conta
    private String nome;//nome do cliente
    private double saldo = 0;//valor total de dinheiro na conta

    public abstract boolean sacar(double valor);

    public Conta(String numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean transferePara(Conta conta, double valor) {
        if (sacar(valor)) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", nome=" + nome + ", saldo=" + String.format("R$%.2f", saldo);
    }

}
