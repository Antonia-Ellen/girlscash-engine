import java.sql.SQLOutput;
import java.util.Scanner;
public class GirlsCashApplication {

    public static void main(String[] args) {

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
            System.out.println("Senha invalida! A senha só pode ter 4 dígitos! Tente novamente.");
            senha = leitor.nextInt();
        }
        contaGirlsCash.definirSenha(senha);
        System.out.println("Senha definida com sucesso!");

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Consultar saldo:");
        System.out.println("2 - Realizar depósito:");
        System.out.println("3 - Realizar saque:");
        System.out.println("4- Solicitar empréstimo:");
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
                            double valorSacado = leitor.nextDouble();
                            contaGirlsCash.sacar (senha, valorSacado);
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

            }
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Consultar saldo:");
            System.out.println("2 - Realizar depósito:");
            System.out.println("3 - Realizar saque:");
            System.out.println("4- Solicitar empréstimo:");
            System.out.println("0 - Sair:");
            opcaoEscolhida = leitor.nextInt();
        }





        /*
        System.out.println("✨ Bem-vinda ao GirlsCash-Engine ✨\n");
        // [Etapa 01] Cálculo de Encargos e Juros do Rotativo
        double saldoInicial = 50.00;
        double juros = saldoInicial * 0.03; //3% de juros
        double multa = saldoInicial * 0.02; //2% de multa

        // Valor total atualizado da fatura com os encargos
        double saldoTotalAtualizado = saldoInicial + juros + multa;

        //Menu com os dados do extrato do cliente
        System.out.println("💸 Saldo Inicial: R$ " + saldoInicial);
        System.out.println("📈 Encargos (Juros + Multa): R$ " + (juros + multa));
        System.out.println("💖 Saldo Devedor Atualizado GirlsCash: R$ " + saldoTotalAtualizado);

        //etapa 2 Análise de Risco

        //colocar se está com o nome negativado
        System.out.println("Nome negativado?: 1 sim e 2 não)");
        int nomeNegativado = leitor.nextInt();

        //assegurar que o número está entre 1 e 2
        while (nomeNegativado < 1 || nomeNegativado > 2) {
            System.out.println("Nome negativado : 1 sim e 2 não)");
            nomeNegativado = leitor.nextInt();
        }

        if (nomeNegativado == 1) {
            System.out.println("Alto Risco! Processo de análise interrompido! Limpe seu nome!");
        } else {
            System.out.println("Baixo Risco. Está liberado para análise do score!");

            //etapa 3 Faixas de limite

            System.out.println("Digite seu score (apenas números!)");
            int scoreDigitado = leitor.nextInt();

            //Verificar se o valor de score está dentro dos padrões(0 a 1000)
            while (scoreDigitado < 0 || scoreDigitado > 1000) {
                //Score inválido! Bloqueia a entrada na regra para que ocorra a correção do valor
                System.out.println("Score inválido! Digite seu score (apenas números entre zero e mil!)");
                scoreDigitado = leitor.nextInt();
            }

            //Score válido! agora vai passar pela regra de negócio (baixo, médio e alto risco))
            if (scoreDigitado >= 750) {
                System.out.println("Limite alto liberado !");
            } else if (scoreDigitado >= 600) {
                System.out.println("Limite médio liberado !");
            } else {
                System.out.println("Liberação recusada. Alto risco!!!");
            }

            //se o score estiver dentro do aceitavel pela empresa
            //vamos liberar o cédito
            if (scoreDigitado >= 600 && scoreDigitado <= 1000 && nomeNegativado == 2) {
                //ETAPA 4:
                // Escolha do produto
                System.out.println("Digite o produto que deseja 1,2 ou 3:");
                System.out.println("1 - Empréstimo Consignado GirlsCash (Taxa: 1.9% a.m.)");
                System.out.println("2 - Empréstimo Pessoal GirlsCash (Taxa: 4.5% a.m.)");
                System.out.println("3 - Cartão de Crédito GirlsCash Black (Anuidade Grátis + Cashback)");
                int opcaoEscolhida = leitor.nextInt();

                //menu com as 3 opções de produto
                while (opcaoEscolhida < 1 || opcaoEscolhida > 3) {
                    System.out.println("Digite o produto que deseja 1,2 ou 3:");
                    System.out.println("1 - Empréstimo Consignado GirlsCash (Taxa: 1.9% a.m.)");
                    System.out.println("2 - Empréstimo Pessoal GirlsCash (Taxa: 4.5% a.m.)");
                    System.out.println("3 - Cartão de Crédito GirlsCash Black (Anuidade Grátis + Cashback)");
                    opcaoEscolhida = leitor.nextInt();
                }
                switch (opcaoEscolhida) {
                    case 1:
                        System.out.println("Empréstimo Consignado GirlsCash (Taxa: 1.9% a.m.)");
                        break;
                    case 2:
                        System.out.println("Empréstimo Pessoal GirlsCash (Taxa: 4.5% a.m.)");
                        break;
                    case 3:
                        System.out.println("Cartão de Crédito GirlsCash Black (Anuidade Grátis + Cashback)");
                        break;
                }

                //Autenticação do cliente antes de realizar a compra
                int pinCorreto = 1234;
                int pinDigitado;
                System.out.println("Digite sua senha de 4 dígitos (apenas números!)");
                pinDigitado = leitor.nextInt();
                //enquanto a senha estiver incorreta o crédito não será liberado
                while (pinCorreto != pinDigitado) {
                    System.out.println("Senha incorreta! Digite novamente!");
                    pinDigitado = leitor.nextInt();
                }
                System.out.println("Senha correta!");

                // ETAPA 5
                // Carnê
                //Define o valor da venda
                System.out.println("CARNÊ:");
                System.out.println("Digite o valor da compra:");
                double valor = leitor.nextDouble();

                //Calcular o valor da parcela
                double calculoParcela = valor / 6;
                // exibir o carnê
                for (int i = 1; i <= 6; i++) {
                    String formatadoValor = String.format("%.2f", calculoParcela);
                    System.out.println(" Parcela " + i + "/6 - Valor: R$ " + formatadoValor + " | Status: A vencer");
                }
            }
        }
        */
    }

}