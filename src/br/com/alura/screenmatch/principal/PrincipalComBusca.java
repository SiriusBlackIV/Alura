package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while(!busca.equalsIgnoreCase("sair")){
        System.out.println("Digite o nome do filme: ");
        busca = leitor.nextLine();
        if (busca.equalsIgnoreCase("sair")){
            break;
        }
        String endereco = "http://www.omdbapi.com/?t="+busca.replace(" ","+")+"&apikey=194cc027";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);


        //Titulo meuTitulo = gson.fromJson(json, Titulo.class);

        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println (meuTituloOmdb);



        try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);

            titulos.add(meuTitulo);

        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro !");
            System.out.println(e.getMessage());
        } catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }}
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("Programa finalizado !");
    }
}
