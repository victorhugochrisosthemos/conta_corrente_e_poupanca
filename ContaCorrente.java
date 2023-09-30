package poo_trabalhoM1;
public class ContaCorrente extends Conta{
    private double valorCobradoPorMovimento;
    public ContaCorrente(String titular, String  numeroConta, double saldoInicial, double saldoCobradoPorMovimento){
        super(titular, numeroConta, saldoInicial);
        this.valorCobradoPorMovimento = valorCobradoPorMovimento;
    }
    public void  atualizarSaldoRendimento(){
        saldo -= valorCobradoPorMovimento;
    }

    public void setValorCobradoPorMovimento(double valorCobradoPorMovimento) {
        this.valorCobradoPorMovimento = valorCobradoPorMovimento;
    }

    public double getValorCobradoPorMovimento() {
        return valorCobradoPorMovimento;
    }

    public String toString(){
        return String.format("Conta Corrente // %s // Valor Cobrado por Movimento: %.2f", super.toString(), getValorCobradoPorMovimento());
    }
}
