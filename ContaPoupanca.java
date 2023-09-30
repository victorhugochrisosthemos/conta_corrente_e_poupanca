package poo_trabalhoM1;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;
    public ContaPoupanca(String titular, String numeroConta, double saldoInicial, double taxaRendimento){
        super(titular, numeroConta, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public void atualizarSaldoRendimento(){
        saldo += saldo * (taxaRendimento / 100);
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    @Override
    public String toString() {
        return String.format("Conta Poupança // %s // Taxa de rendimento: %.2f", super.toString(), getTaxaRendimento());
    }


}
