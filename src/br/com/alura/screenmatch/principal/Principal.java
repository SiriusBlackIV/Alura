package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodios;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Series;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Harry Potter",2001);
        meuFilme.setDuracaoEmMinutos(180);

        Filme meuFilme2 = new Filme("O Conde de Monte Cristo",2002);
        meuFilme2.setDuracaoEmMinutos(120);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(9);
        meuFilme.avalia(9.5);
        meuFilme.avalia(10);
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Series minhaSerie = new Series("The Big Bang Theory",2007);
        minhaSerie.setAtiva(false);
        minhaSerie.setTemporadas(12);
        minhaSerie.setEpisodiosPorTemporada(23);
        minhaSerie.setMinutosPorEpisodio(30);
        minhaSerie.exibeFichaTecnica();
        System.out.println("A média de episódios por temporada é: " + minhaSerie.getEpisodiosPorTemporada());
        System.out.println(minhaSerie.isAtiva());
        System.out.println("Para maratonar " + minhaSerie.getNome() + " você gastará " + minhaSerie.getDuracaoEmMinutos() + " minutos");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(meuFilme2);
        calculadora.inclui(minhaSerie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodios episodio = new Episodios();
        episodio.setNumero(1);
        episodio.setSerie(minhaSerie);
        episodio.setTotalVisualizacoes(1000);
        filtro.filtra(episodio );

        var novoFilme = new Filme("O ilusionista",2002);
        novoFilme.setDuracaoEmMinutos(134);


        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(meuFilme2);
        listaDeFilmes.add(novoFilme);
        System.out.println("O tamanho da lista de filmes: " + listaDeFilmes.size());
        System.out.println("O primeiro filme da lista é: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);




    }
}