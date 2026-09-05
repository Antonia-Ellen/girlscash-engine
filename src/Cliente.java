public class Cliente {
    //proteger pra que ninguém altere os dados fora dessa classe
    private String nome;
    private String cpf;
    private int score;
    private boolean negativado;

    //construtor
    public Cliente() {
        nome = "Ellen";
        cpf = "123.456.789";
        score = 601;
        negativado = false;
    }

    public Cliente(String nome, String cpf, int score, boolean negativado) {
        this.nome = nome;
        this.cpf = cpf;
        this.score = score;
        this.negativado = negativado;
    }

    //libera outra classe a ver o nome
    public String getNome() {
        return nome;
    }

    //libera outra classe a alterar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isNegativado() {
        return negativado;
    }

    public void setNegativado(boolean negativado) {
        this.negativado = negativado;
    }

    //não precisa adicionar variavel de parametro porque estamos dentro de titular
    //se fosse fora iria precisar (boolean negativado, int score)
    public boolean eElegivelParaCredito() {
        //retorna o sim ou não se não for negativado e o score for maior ou igual a 600
    return !negativado && score >= 600;
    }
}
