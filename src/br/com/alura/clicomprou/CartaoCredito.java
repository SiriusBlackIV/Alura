package br.com.alura.clicomprou;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private double limite;
    private int senha;

    private double saldo;

    private List<Compra> compras;

    public CartaoCredito(double limite, int senha) {
        this.limite = limite;
        this.senha = senha;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }
    public boolean lancaCompra(Compra compra){
        if (this.senha != compra.getSenha() && this.saldo > compra.getValor()) {
            System.out.println("Senha digitada incorreta !");
            return false;
        } else if (this.senha == compra.getSenha() && this.saldo > compra.getValor()) {
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        } else if (this.senha == compra.getSenha() && this.saldo < compra.getValor()) {
            System.out.println("Limite insuficiente para concluir a compra.");

        }
        return false;

    }

    public double getLimite() {
        return limite;
    }

    public int getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
