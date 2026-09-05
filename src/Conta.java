import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Conta {
    protected Cliente titular;
    protected String agencia;
    protected String numeroConta;
    protected double saldo;
    protected double limiteCredito;
    protected int pin;
    protected List<String> extrato =  new ArrayList<>();

    public Conta(Cliente titular, int pin) {
        this.titular = titular;
        this.pin = pin;
    }

    public double getsaldo(){
        return this.saldo;
    }
    public double getlimiteCredito(){
        return this.limiteCredito;
    }
    public Cliente getTitular(){
        return this.titular;
    }
    public double mostrarSaldo() {
       return this.saldo;
    }

    public int definirSenha(int senha){
        return this.pin;
    }

    //metodo para receber um valor de depósito
    //não precisa retornar o valor = void
    public void depositar(double valor){
        saldo += valor;
        extrato.add("R$" + valor + " depositado com sucesso!");
    }

    //método para sacar um valor passado por parâmetro
    //se a senha estiver correta e tiver saldo
    // deve retornar um boolean (true/false)
    public void sacar (int PIN, double valor) throws SenhaInvalidaException, SaldoInsuficienteException{
        if (!analisarPin(PIN)) {
            SenhaInvalidaException senhaInvalida = new SenhaInvalidaException();
            throw senhaInvalida;
        }
        if (!(valor <= saldo)) {
            SaldoInsuficienteException erro = new SaldoInsuficienteException();
            throw erro;
        } else {
        saldo -= valor;
            extrato.add("R$" + valor + " sacado com sucesso!");
        }
    }

     public boolean solicitarEmprestimo(double valor){
        if(titular.eElegivelParaCredito()) {
            saldo += valor;
            extrato.add("Empréstimo de R$" + valor + " foi solicitado com sucesso!");
            return true;
        }else {
            return false;
        }
     }

     //método para analisar se a senha digitado está correta
     public boolean analisarPin(int valorPin){
        return this.pin == valorPin;
     }

     public void mostrarExtrato(){
        for (String movimentacao:extrato) {
            System.out.println(movimentacao);
        }
     }

     public void salvarExtratoEmArquivo() {
             try (FileWriter myWriter = new FileWriter("HistoricoGirlsCashEngine.txt")) {
                 for (String movimentacao:extrato){
                     myWriter.write(movimentacao + "\n");
                 }
                 System.out.println("Arquivo salvo com sucesso!");
             } catch (IOException e) {
                 System.out.println("Houve um um erro ao salvar o arquivo!");
                 e.printStackTrace();
             }
         }
     }