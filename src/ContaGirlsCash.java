public class ContaGirlsCash {
   private Cliente cliente;
    private double saldo;
    private double limiteCredito;
    private int pin;

    public ContaGirlsCash (Cliente Cliente, int pin) {
        this.cliente = Cliente;
        this.pin = pin;
    }

    //metodo para receber um valor de depósito
    //não precisa retornar o valor = void
    public void depositar(double valor){
        saldo += valor;
    }

    //método para sacar um valor passado por parâmetro
    //que deve retornar um boolean (true/false)
    public boolean sacar(double valor){
        if (valor <= saldo){
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
}
