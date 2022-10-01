package com.api.webscrapingmagalu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.webscrapingmagalu.model.WebScraping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class WebScrapingMagaluApplication {

    public WebScrapingMagaluApplication() throws IOException {
    }

    public static List<WebScraping> extrairDados() throws IOException {
        //1 - URL do site a ser acessado
        String url = "https://www.magazineluiza.com.br/busca/smartphone/?page=1";
        //2 - Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();
        //3 - Obtendo a tabela através de sua classe
        Element table = doc.getElementsByClass("sc-hKwDye bbqWyp sc-jLuXOi isPgPe").first();
        //4 - Obtendo o corpo da tabela através da tag
        Element tbody = table.getElementsByClass("sc-cNKqjZ fPxdtb sc-iIUQWv gIPgyk sc-fDZUdJ iAfIUF").first();
        //5 - Criando uma lista de todos os tr's do tbody obtido
        List<Element> players = tbody.getElementsByClass("sc-fBNLhH iSRQeC");
        List<Element> valores = tbody.getElementsByClass("sc-hKwDye iKLUrB sc-itWPBs jrSJVN");
        //6 - Criando uma lista vazia para Guardar os dados dos tr's convertidos
        List<WebScraping> playersObjects = new ArrayList<>(); 
        //7 - Iterando por cada tr e convertendo-o em um Passing. Em seguida inserindo-o na lista de Passings
        for (Element player: players) {
            //Listando todos os atributos do tr em questão
            List<Element> attributes = player.getElementsByClass("sc-hFxENk fskQXn");
            List<Element> attributeValor = ((Element) valores).getElementsByClass("sc-crHmcD bKgmQY sc-hGnimi ddEjGv");
            //criando o objeto e inserindo nele os atributos extraidos do td
            WebScraping passing = new WebScraping();
            passing.setNomeProduto(attributes.get(0).text());
            passing.setValorProduto(attributeValor.get(1).text());

            //adicionando o objeto na lista de objetos Passing
            playersObjects.add(passing);
        }

        return playersObjects;
    }

    public static void main(String[] args) throws IOException {

        int count = 0;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    //int i = 1;
    for(int j = 1; j<=2;j++){
        
        //1 - URL do site a ser acessado
        String url = "https://www.magazineluiza.com.br/busca/smartphone/?page="+j;
        //2 - Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();
        //3 - Obtendo os artigos por classe
        List<Element> artigos = doc.getElementsByClass("sc-cnHmbd dQVIVc");
        List<Element> valorProduto = doc.getElementsByClass("sc-hKwDye iKLUrB sc-itWPBs jrSJVN");
        
        List<Element> nome = new ArrayList<>();
        List<String> valor = new ArrayList<>();

        List<Element> dinheiro = new ArrayList<>();
        List<String> listDinheiro = new ArrayList<>();

        //4 - Obtendo as tags "a" dos artigos
            artigos.forEach(element -> {
                nome.add(element.getElementsByTag("h2").first());                   
            });

            valorProduto.forEach(element ->{
                dinheiro.add(element.getElementsByClass("sc-crHmcD cUbEYF sc-iukxot cqVUBD").first());
            });

        //5 - Obtendo as urls das tags a
            nome.forEach(element -> {
                valor.add(element.attr("sc-hFxENk fskQXn"));
            });

            valorProduto.forEach(element -> {
                listDinheiro.add(element.attr("sc-hFxENk fskQXn"));
            });
        //6 - Imprimindo os links
        
            nome.forEach(s -> {
                
               System.out.println("Produto: "  + s.text() +  " || Valor: "+ dinheiro.get(count).text() + "  || Data: " + dateFormat.format(date));
                
            });  
            
    }
}

    //Bonus: método para converter um objeto em um Json
    private static void converterToJson(WebScraping passing){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(passing);
            System.out.println("Objeto em JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
