public class ContaGirlsCash {
    private Cliente cliente;
    private double saldo;
    private double limiteCredito;
    private int pin;

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

    //metodo para receber um valor de depósito
    //não precisa retornar o valor = void
    public void depositar(double valor){
        saldo += valor;
    }

    //método para sacar um valor passado por parâmetro
    //se a senha estiver correta e tiver saldo
    // deve retornar um boolean (true/false)
    public boolean sacar(int PIN, double valor){
        if (analisarPin(PIN) && valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

     public boolean solicitarEmprestimo(double valor){
        if(cliente.eElegivelParaCredito()) {
            saldo += valor;
            return true;
        }else {
            return false;
        }
     }

     //método para analisar se a senha digitado está correta
     public boolean analisarPin(int valorPin){
        return this.pin == valorPin;
     }
}
