package br.com.alura.clicomprou;

public class Compra {
    private String descricao;
    private double valor;
    private int senha;

    public Compra(String descricao, double valor, int senha) {
        this.descricao = descricao;
        this.valor = valor;
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Compra: descrição = " + descricao +
                "valor = " + valor;
    }
}
