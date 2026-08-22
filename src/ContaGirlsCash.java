import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class ContaGirlsCash {
    private Cliente cliente;
    private double saldo;
    private double limiteCredito;
    private int pin;
    private List<String> extrato =  new ArrayList<>();

    public ContaGirlsCash (Cliente Cliente, int pin) {
        this.cliente = Cliente;
        this.pin = pin;
    }

    public double getsaldo(){
        return this.saldo;
    }
    public double getlimiteCredito(){
        return this.limiteCredito;
    }
    public Cliente getCliente(){
        return this.cliente;
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
        if(cliente.eElegivelParaCredito()) {
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