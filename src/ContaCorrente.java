public class ContaCorrente extends Conta {
    private double taxaMovimentacao = 1.50;

    public ContaCorrente(Cliente titular, int pin) {
        super(titular, pin);
    }

    @Override
    public void sacar(int PIN, double valor) throws SenhaInvalidaException, SaldoInsuficienteException {
        if (!analisarPin(PIN)) {
            SenhaInvalidaException senhaInvalida = new SenhaInvalidaException();
            throw senhaInvalida;
        }
        System.out.println("Lembre-se que será descontado R$1.50 a cada saque");
        double valorASacar = valor + taxaMovimentacao;
        if (!(valorASacar <= saldo)) {
            SaldoInsuficienteException erro = new SaldoInsuficienteException();
            throw erro;
        } else {
            saldo  -= valorASacar;
            extrato.add("R$" + valor + " sacado com sucesso!");

        }
    }
}
