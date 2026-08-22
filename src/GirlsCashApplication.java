import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;
public class GirlsCashApplication {

    public static void main(String[] args) throws SenhaInvalidaException, SaldoInsuficienteException{

        Scanner leitor = new Scanner(System.in);

        Cliente cliente = new Cliente();
        System.out.println("Digite seu nome:");
        //leitor.nextLine para strings em objetos
        String nome = leitor.nextLine();
        cliente.setNome(nome);
        System.out.println("Digite seu CPF:");
        String CPF = leitor.nextLine();
        cliente.setCPF(CPF);
        System.out.println("Digite seu SCORE:");
        int score = leitor.nextInt();
        cliente.setScore(score);
        System.out.println("Você está negativado? SIM - True/NÃO - False: ");
        boolean negativado = leitor.nextBoolean();
       cliente.setNegativado(negativado);

        ContaGirlsCash contaGirlsCash = new ContaGirlsCash(cliente, 1234);
        int conta = 1;
        System.out.println("Bem vinda: " + cliente.getNome() +" Conta: "+ conta);
        System.out.println("Defina sua senha de 4 números:");
        int senha = leitor.nextInt();
        while (senha >= 10000){
            System.out.println("Senha invalida! A senha só pode ter no máximo 4 dígitos! Tente novamente.");
            senha = leitor.nextInt();
        }
        contaGirlsCash.definirSenha(senha);
        System.out.println("Senha definida com sucesso!");

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Consultar saldo:");
        System.out.println("2 - Realizar depósito:");
        System.out.println("3 - Realizar saque:");
        System.out.println("4- Solicitar empréstimo:");
        System.out.println("5 - Mostrar extrato");
        System.out.println("0 - Sair:");
        int opcaoEscolhida = leitor.nextInt();
        while(opcaoEscolhida != 0){
            switch (opcaoEscolhida){
                case 1:
                    System.out.println("Saldo disponível: R$ " + contaGirlsCash.mostrarSaldo());
                    break;
                    case 2:
                        System.out.println("Digite o valor a ser depositado: ");
                        double valorDeposito = leitor.nextDouble();
                        contaGirlsCash.depositar(valorDeposito);
                        break;
                        case 3:
                            System.out.println("Digite o valor a ser sacado: ");
                            double valorASerSacado = leitor.nextDouble();
                            System.out.println("Digite sua senha: ");
                            int senhaParaSaque =  leitor.nextInt();
                            try {
                                contaGirlsCash.sacar(senhaParaSaque, valorASerSacado);
                                System.out.println("Saque realizado com sucesso!");
                            }catch (SenhaInvalidaException e){
                                System.out.println(e.getMessage());
                            }
                            catch (SaldoInsuficienteException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                            case 4:
                                System.out.println("Digite o valor que deseja solicitar emprestado: ");
                                double valorEmprestimo = leitor.nextDouble();
                                if (contaGirlsCash.solicitarEmprestimo(valorEmprestimo)){
                                    System.out.println("Você está elegível para Credito!");
                                    System.out.println("Empréstimo de R$" + valorEmprestimo + " realizado com sucesso!");
                                }else {
                                    System.out.println("Você não está elegível para Credito!");
                                }
                                break;
                                case 5:
                                    contaGirlsCash.mostrarExtrato();
                                    break;

            }
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Consultar saldo:");
            System.out.println("2 - Realizar depósito:");
            System.out.println("3 - Realizar saque:");
            System.out.println("4- Solicitar empréstimo:");
            System.out.println("5 - Mostrar extrato");
            System.out.println("0 - Sair:");
            opcaoEscolhida = leitor.nextInt();
        }
        contaGirlsCash.salvarExtratoEmArquivo();
    }
}