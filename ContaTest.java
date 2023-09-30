package poo_trabalhoM1;
import java.util.ArrayList;
import java.util.Scanner;

public class ContaTest {
    public static void main(String[] args){
        boolean sair  = false;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        do{
            System.out.println("- - - - - - - - - - - - - - -");
            System.out.println("1 - Cadastramento de conta");
            System.out.println("2 - Saque");
            System.out.println("3 - Depósito");
            System.out.println("4 - Extrato");
            System.out.println("5 - Rendimento da conta poupança");
            System.out.println("6 - Listagem das contas existentes");
            System.out.println("7 - Sair");
            System.out.println("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastro(scanner, contas);
                case 2 -> saque(scanner, contas);
                case 3 -> deposito(scanner, contas);
                case 4 -> extrato(scanner, contas);
                case 5 -> gerarRendimento(contas);
                case 6 -> listarContas(contas);
                case 7 -> sair = true;
                default -> System.out.println("Opcao invalida!");
            }
        } while(!sair);
    }
    private static void cadastro(Scanner scanner, ArrayList<Conta> contas){
        System.out.print("Digite o nome do titular: ");
        scanner.nextLine();
        String titular = scanner.nextLine();
        System.out.print("Informe o numero da conta: ");
        String numeroConta = scanner.next();
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        System.out.println("Informe o tipo de conta:");
        System.out.println("    1 - Conta poupança");
        System.out.println("    2 - Conta corrente");

        int tipoConta = scanner.nextInt();

        if(tipoConta == 1){
            System.out.print("Digite a taxa de rendimento em %: ");
            double taxaRendimento =scanner.nextDouble();
            ContaPoupanca contaPoupanca = new ContaPoupanca(titular, numeroConta, saldoInicial, taxaRendimento);
            contas.add(contaPoupanca);
        }else if(tipoConta == 2){
            System.out.print("Digite o valor cobrado por movimento: ");
            double valorCobradoPorMovimento = scanner.nextDouble();
            ContaCorrente contaCorrente = new ContaCorrente(titular, numeroConta, saldoInicial, valorCobradoPorMovimento);
            contas.add(contaCorrente);
        }else{
            System.out.println("Opção inválida!");
        }
    }
    public static void saque(Scanner scanner, ArrayList<Conta> contas){
        System.out.print("Informe o número da conta: ");
        String numeroConta = scanner.next();
        System.out.print("Informe o valor a ser retirado da conta: ");
        double valorSaque = scanner.nextDouble();
        for(Conta conta: contas){
            if(conta.getNumeroConta().equals(numeroConta)){
                conta.sacar(valorSaque);
                conta.atualizarSaldoRendimento();
                return;
            }
        }
        System.out.println("Conta inexistente!");
    }
    private static void deposito(Scanner scanner, ArrayList<Conta> contas){
        System.out.print("Informe o número da conta: ");
        String numeroConta = scanner.next();
        System.out.print("Informe o valor a ser depositado: ");
        double valorDeposito = scanner.nextDouble();
        for(Conta conta: contas){
            if(conta.getNumeroConta().equals(numeroConta)){
                conta.depositar(valorDeposito);
                conta.atualizarSaldoRendimento();
                System.out.println("Depósito de " + valorDeposito + " realizado!");
                return;
            }
        }
        System.out.println("Conta inexistente!");
    }
    private static void extrato(Scanner scanner, ArrayList<Conta> contas){
        System.out.println("Informe o número da conta\n");
        String numeroConta = scanner.next();
        for(Conta conta: contas){
            if(conta.getNumeroConta().equals(numeroConta)){
                System.out.println(conta);
                return;
            }
        }
        System.out.println("Conta inexistente!");
    }
    private static void gerarRendimento(ArrayList<Conta> contas){
        for(Conta conta: contas){
            if(conta instanceof ContaPoupanca contaPoupanca){
                contaPoupanca.atualizarSaldoRendimento();
                System.out.println("Rendimento efetuado na conta  poupança " + contaPoupanca.getNumeroConta());
            }
        }
    }
    private static void listarContas(ArrayList<Conta> contas){
        System.out.println("Lista de contas: ");
        for(Conta conta:contas){
            System.out.println(conta);
        }
    }
}
