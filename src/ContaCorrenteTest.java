import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ContaCorrenteTest {
        @Test
        public void deveCobrarTaxaDeSaque() throws Exception {
            // Aqui vai entrar o código do teste
                Cliente novoCliente = new Cliente();
                int senha = 7894;
                ContaCorrente conta = new ContaCorrente(novoCliente, senha);
                double valor = 100;
                conta.depositar(valor);
                double valorSaque = 50.00;
                conta.sacar(senha, valorSaque);
                assertEquals(48.50, conta.mostrarSaldo());
        }
        @Test
        public void deveLancarErroSeSaldoForInsuficiente() {
                // 1. Preparação (Arrange)
                Cliente cliente = new Cliente();
                int senha = 1234;
                ContaCorrente conta = new ContaCorrente(cliente, senha);
                conta.depositar(100.00);

                // 2 e 3. Ação e Validação juntas (Act & Assert)
                // O JUnit verifica se a tentativa de sacar R$ 200 (em uma conta com R$ 100)
                // vai obrigatoriamente acionar a SaldoInsuficienteException.
                org.junit.jupiter.api.Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
                        conta.sacar(senha, 200.00);
                });
        }
}
