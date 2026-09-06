Markdown
# 🌸 GirlsCash Engine — Sistema Bancário em Java

O **GirlsCash Engine** é uma aplicação Java de console que simula um terminal bancário/caixa eletrônico interativo. O projeto foi desenvolvido com foco no domínio de **Programação Orientada a Objetos (POO)**, validação de regras de negócio, tratamento robusto de exceções e persistência de dados.

---

## 🚀 Funcionalidades

- **Abertura de Conta & Segurança:** Cadastro com titular, agência, conta e autenticação via PIN de 4 dígitos.
- **Operações Financeiras:** Depósitos e saques com validação em tempo real de saldo e credenciais.
- **Simulação de Empréstimo:** Avaliação de elegibilidade baseada em regras prévias de movimentação.
- **Histórico & Extrato Dinâmico:** Rastreamento de todas as transações realizadas durante a sessão utilizando `ArrayList`.
- **Tratamento de Exceções Personalizadas:** Controle de falhas críticas de negócio sem interrupção abrupta do sistema.
- **Persistência em Arquivo (.txt):** Salvamento automático do histórico de transações em disco (`HistoricoGirlsCashEngine.txt`) ao encerrar a execução.

## 🏗️ Arquitetura e Conceitos Aplicados (Módulo 6)

O sistema foi refatorado para suportar diferentes tipos de contas bancárias, aplicando os pilares da Programação Orientada a Objetos:

* **Herança:** Criação de uma classe mãe genérica `Conta` para compartilhar atributos e métodos comuns com as classes filhas `ContaCorrente` e `ContaPoupanca`.
* **Polimorfismo:** Sobrescrita (`@Override`) do método `sacar()` na `ContaCorrente` para incluir regras de negócio específicas (cobrança de taxa por saque).
* **Encapsulamento (`protected`):** Atributos da classe mãe protegidos para serem manipulados apenas pelas classes filhas de forma segura.
* **Casting (Downcasting):** Conversão dinâmica de tipos usando `instanceof` para acessar métodos exclusivos em tempo de execução (ex: método `render()` exclusivo da `ContaPoupanca`).
---
## 🧪 Módulo 7: Testes Automatizados (Qualidade de Software)

Para garantir a confiabilidade das regras financeiras do sistema e evitar regressões, foram implementados testes de unidade.

* **Ferramenta:** JUnit 5.
* **Padrão Aplicado:** AAA (Arrange, Act, Assert).
* **Cenários Cobertos:**
  * Validação da cobrança exata da taxa de saque na `ContaCorrente`.
  * Prevenção de saques indevidos (Caminho Triste testando o lançamento da `SaldoInsuficienteException`).
  * Cálculo preciso do método de rendimento da `ContaPoupanca`.

## 🛠️ Tecnologias & Conceitos Aplicados

- **Linguagem:** Java (JDK 17+)
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Encapsulamento:** Modificadores de acesso e métodos de controle
- **Estruturas de Dados:** `ArrayList` e laços de iteração `for-each`
- **Controle de Exceções:**
   - Criação de exceções checadas (`SaldoInsuficienteException` e `SenhaInvalidaException`)
   - Estruturas de controle de fluxo com `throws`, `throw` e `try-catch`
- **Manipulação de Arquivos (Java I/O):**
   - Gravação de dados em arquivo físico com `FileWriter`
   - Gerenciamento seguro de recursos com a instrução `try-with-resources`
- **Versionamento:** Git & GitHub

---

💻 Como Executar o Projeto
Clone o repositório:

Bash
git clone [https://github.com/Antonia-Ellen/girlscash-engine.git](https://github.com/Antonia-Ellen/girlscash-engine.git)
Abra a pasta do projeto na sua IDE preferida (IntelliJ IDEA, VS Code ou Eclipse).

Execute o arquivo Main.java.

Interaja com as opções do menu no console. Ao digitar 0 para sair, o histórico de movimentações será gravado automaticamente no arquivo HistoricoGirlsCashEngine.txt.

👩‍💻 Autora
Desenvolvido por Antônia Ellen.

Projeto desenvolvido com foco em aprimoramento de lógica, POO e boas práticas de desenvolvimento de software em Java.

## 📁 Estrutura do Projeto

```text
src/
├── Conta.java               # Regras de negócio e operações da conta
├── Main.java                         # Interface de terminal e fluxo do menu
├── SaldoInsuficienteException.java   # Exceção para tentativas de saque acima do saldo
├── SenhaInvalidaException.java       # Exceção de segurança para PIN incorreto
└── HistoricoGirlsCashEngine.txt     # Arquivo gerado com o log de transações

