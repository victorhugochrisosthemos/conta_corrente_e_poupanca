package poo_trabalhoM1;

import java.util.ArrayList;

public abstract class Conta {
    private String titular;
    private String numeroConta;
    protected double saldo;
    protected ArrayList<Double> historicoMovimentos;
    public Conta (String titular, String numeroConta, double saldoInicial){
        this.titular= titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.historicoMovimentos = new ArrayList<>();
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){
        saldo += valor;
        historicoMovimentos.add(valor);
    }
    public void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            historicoMovimentos.add(-valor);
            System.out.println("Saque de " + valor + " efetuado com sucesso!");
        }else{
            System.out.println("Saldo insuficiente para saque.");
        }
    }
    public abstract void atualizarSaldoRendimento();
    public String toString(){
        return String.format("Titular: " + titular + " // Numero da conta: " + numeroConta + "// Saldo: " + saldo);
    }

}
