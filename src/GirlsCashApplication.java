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

        System.out.println("Bem vinda: " + cliente.getNome());
        System.out.println("Escolha o tipo de conta que deseja abrir:");
        System.out.println("1 - CONTA CORRENTE");
        System.out.println("2 - CONTA POUPANÇA");
        int tipoConta = leitor.nextInt();
        while(tipoConta <1 || tipoConta > 2){
            System.out.println("conta invalida! Tente novamente digitando 1 ou 2");
            tipoConta = leitor.nextInt();
        }
        System.out.println("Agora defina sua senha de 4 números:");
        int senha = leitor.nextInt();
        while (senha >= 10000){
            System.out.println("Senha invalida! A senha só pode ter no máximo 4 dígitos! Tente novamente.");
            senha = leitor.nextInt();
        }
        Conta conta;
        if(tipoConta == 1){
            conta = new ContaCorrente(cliente,senha);
            System.out.println("conta Corrente escolhida com sucesso!");
        }else{
            conta = new ContaPoupanca(cliente,senha);
            System.out.println("conta Poupança escolhida com sucesso!");
        }

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Consultar saldo:");
        System.out.println("2 - Realizar depósito:");
        System.out.println("3 - Realizar saque:");
        System.out.println("4- Solicitar empréstimo:");
        System.out.println("5 - Aplicar rendimento:");
        System.out.println("6 - Mostrar extrato:");
        System.out.println("0 - Sair:");
        int opcaoEscolhida = leitor.nextInt();
        while(opcaoEscolhida != 0){
            switch (opcaoEscolhida){
                case 1:
                    System.out.println("Saldo disponível: R$ " + conta.mostrarSaldo());
                    break;
                    case 2:
                        System.out.println("Digite o valor a ser depositado: ");
                        double valorDeposito = leitor.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                        case 3:
                            System.out.println("Digite o valor a ser sacado: ");
                            double valorASerSacado = leitor.nextDouble();
                            System.out.println("Digite sua senha: ");
                            int senhaParaSaque =  leitor.nextInt();
                            try {
                                conta.sacar(senhaParaSaque, valorASerSacado);
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
                                if (conta.solicitarEmprestimo(valorEmprestimo)){
                                    System.out.println("Você está elegível para Credito!");
                                    System.out.println("Empréstimo de R$" + valorEmprestimo + " realizado com sucesso!");
                                }else {
                                    System.out.println("Você não está elegível para Credito!");
                                }
                                break;
                                case 5:
                                    if (tipoConta == 2){
                                        ((ContaPoupanca)conta).render();
                                    }
                                    break;
                                    case 6:
                                        conta.mostrarExtrato();
                                        break;

            }
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Consultar saldo:");
            System.out.println("2 - Realizar depósito:");
            System.out.println("3 - Realizar saque:");
            System.out.println("4- Solicitar empréstimo:");
            System.out.println("5 - Aplicar rendimento:");
            System.out.println("6 - Mostrar extrato:");
            System.out.println("0 - Sair:");
            opcaoEscolhida = leitor.nextInt();
        }
        conta.salvarExtratoEmArquivo();
    }
}