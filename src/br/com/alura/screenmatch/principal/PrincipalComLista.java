package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Series;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Harry Potter",2001);
        meuFilme.avalia(10);
        Filme meuFilme2 = new Filme("O Conde de Monte Cristo",2002);
        meuFilme2.avalia(9);
        var novoFilme = new Filme("O ilusionista",2000);
        novoFilme.avalia(8);
        Series minhaSerie = new Series("The Big Bang Theory",2007);

        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(meuFilme2);
        listaDeAssistidos.add(novoFilme);
        listaDeAssistidos.add(minhaSerie);

        for ( Titulo item: listaDeAssistidos) {
            System.out.println(item.getNome());

            if (item instanceof Filme filme){
                System.out.println("Classificação: " + filme.getClassificacao() + " estrelas");
            }else {
                System.out.println("Não possui o metodo de classificação implementado");
            }
        }
        Collections.sort(listaDeAssistidos);
        System.out.println(listaDeAssistidos);
        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(listaDeAssistidos);

    }
}
