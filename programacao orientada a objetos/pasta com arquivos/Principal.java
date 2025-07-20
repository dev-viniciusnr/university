
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static List<Conta> lista = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private static Conta findByNumero(String numero) {
        for (Conta c : lista) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        System.out.println("Numero de conta inválido");
        return null;
    }

    private static void criaContaComum() {
        System.out.println("Entre com o numero da conta");
        String numero = sc.next();
        if (findByNumero(numero) != null) {
            System.out.println("Numero de conta já cadastrado!");
            return;
        }
        System.out.println("Entre com o nome do cliente");
        String nome = sc.next();

        lista.add(new ContaComum(numero, nome));
    }

    private static void criaContaEspecial() {
        System.out.println("Entre com o numero da conta");
        String numero = sc.next();
        if (findByNumero(numero) != null) {
            System.out.println("Numero de conta já cadastrado!");
            return;
        }

        System.out.println("Entre com o nome do cliente");
        String nome = sc.next();

        System.out.println("Entre com o limite");
        double limite = sc.nextDouble();

        lista.add(new ContaEspecial(numero, nome, limite));
    }

    private static void mostrarContas() {
        if (lista.isEmpty()) {
            System.out.println("Não existe nenhuma conta cadastrada");
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    private static void depositar() {
        Conta origem = null;
        System.out.println("Entre com o numero da conta de origem");
        origem = findByNumero(sc.next());
        if (origem == null) {
            return;
        }
        System.out.println("Entre com o valor a ser depositado");
        origem.depositar(sc.nextDouble());
        System.out.println("valores atualizados:");
        System.out.println(origem.toString());
    }

    private static void sacar() {
        Conta origem = null;
        System.out.println("Entre com o numero da conta de origem");
        origem = findByNumero(sc.next());
        if (origem == null) {
            return;
        }
        System.out.println("Entre com o valor a ser depositado");
        if (origem.sacar(sc.nextDouble())) {
            System.out.println("Saque realizado com sucesso");
            System.out.println("valores atualizados:");
            System.out.println(origem.toString());
        } else {
            System.out.println("Não foi possível sacar. Saldo insuficiente.");
        }
    }

    private static void transferir() {
        Conta origem = null;
        Conta destino = null;
        System.out.println("Entre com o numero da conta de origem");
        origem = findByNumero(sc.next());
        if (origem == null) {
            return;
        }
        System.out.println("Entre com o numero da conta de destino");
        destino = findByNumero(sc.next());
        if (destino == null) {
            return;
        }
        System.out.println("Entre com o valor a ser transferido");
        if (origem.transferePara(destino, sc.nextDouble())) {
            System.out.println("Valor transferido com sucesso");
            System.out.println("valores atualizados:");
            System.out.println(origem.toString());
            System.out.println(destino.toString());
        } else {
            System.out.println("Não foi possível transferir. Saldo insuficiente.");
        }

    }

    public static void main(String[] args) {

        int menu = 0;

        do {
            System.out.println("-------Menu Principal-------");
            System.out.println("---0 - Sair do programa");
            System.out.println("---1 - Criar Conta Comum");
            System.out.println("---2 - Criar Conta Especial");
            System.out.println("---3 - Mostrar Contas Cadastradas");
            System.out.println("---4 - Sacar");
            System.out.println("---5 - Depositar");
            System.out.println("---6 - Transferir de uma conta para outra");
            menu = sc.nextInt();
            switch (menu) {
                case 0:
                    break;
                case 1:
                    criaContaComum();
                    break;
                case 2:
                    criaContaEspecial();
                    break;
                case 3:
                    System.out.println("---Contas cadastradas---");
                    mostrarContas();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    depositar();
                    break;
                case 6:
                    transferir();
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        } while (menu != 0);

        System.exit(0);
    }
}
