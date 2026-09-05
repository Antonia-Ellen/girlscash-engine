public class ContaPoupanca extends Conta {
    private double taxaPorcentagem = 0.02;
    public ContaPoupanca(Cliente titular, int pin) {
        super(titular, pin);
    }

    public void render(){
        double rendimento = saldo * taxaPorcentagem;
        saldo += rendimento;
        extrato.add("Seu saldo rendeu R$" + rendimento);
        extrato.add("Seu saldo atual é R$" + saldo);


    }
}
