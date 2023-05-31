package br.com.alura.buscadorcep;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        ConsultaCep consultaCep = new ConsultaCep();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o CEP: ");
        int cepDigitado = leitor.nextInt();
        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(String.valueOf(cepDigitado));
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
            System.out.println(novoEndereco);

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a consulta...");
            System.out.println("Programa encerrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
