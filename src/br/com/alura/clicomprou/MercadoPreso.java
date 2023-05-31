package br.com.alura.clicomprou;

import java.util.Random;
import java.util.Scanner;

public class MercadoPreso {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double limite = new Random().nextInt(2000);
        System.out.println("Para gerar o seu cartão, crie uma senha de 4 dígitos: ");
        int senha = leitor.nextInt();

        CartaoCredito cartao = new CartaoCredito(limite, senha);
        System.out.println("Seja bem vindo ! O seu cartão foi gerado com o limite de: R$ " + limite);

        int sair = 1;
        while (sair != 0){

            System.out.println("Digite a descrição da compra: ");
            String descricao = leitor.next();

            System.out.println("Digite o valor da compra: ");
            double valor = leitor.nextDouble();

            System.out.println("Digite a sua senha: ");
            int validaSenha = leitor.nextInt();

            Compra compra = new Compra(descricao, valor, validaSenha);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){
                System.out.println("Sua compra foi realizada com sucesso !");
                System.out.println("Digite 0 para sair ou 1 para continuar comprando: ");
                sair = leitor.nextInt();

            } else {
                System.out.println("Compra não foi processada, tente novamente!");
            }
        }

        System.out.println("***************************************************************");
        System.out.println("                     Histórico de Compras \n                      ");
        for (Compra c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - " + " R$ " + c.getValor());
        }
        System.out.println("\n      ********************************************         ");
        System.out.println("\n Limite disponível: R$ " + cartao.getSaldo());
        System.out.println("***************************************************************");
    }
}
