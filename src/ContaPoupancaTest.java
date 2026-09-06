import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ContaPoupancaTest {
    @Test
    public void testarRendimentos (){
        Cliente clienteTeste = new Cliente();
        ContaPoupanca poupancaTeste = new ContaPoupanca(clienteTeste, 1234);
        poupancaTeste.depositar(100.00);
        poupancaTeste.render();
        double valorEsperado = 102;
        assertEquals(valorEsperado, poupancaTeste.mostrarSaldo());
    }
}
