package com.api.webscrapingmagalu;

import com.api.webscrapingmagalu.model.WebScraping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebScrapingMagaluApplication {

    public WebScrapingMagaluApplication() throws IOException {
    }

    /*public static List<WebScraping> extrairDados() throws IOException {

        String url = "https://www.magazineluiza.com.br/busca/notebook/?page=1";
        Document doc = Jsoup.connect(url).get();

        Element section = doc.getElementsByClass("sc-eCImPb fJOKbp").first();
        Element div = section.getElementsByClass("sc-hKwDye bbqWyp sc-jLuXOi isPgPe").first();
        //Element table = div.getElementsByClass("sc-cNKqjZ fPxdtb sc-iIUQWv gIPgyk sc-fDZUdJ iAfIUF").first();
        Element ul = div.getElementsByTag("ul").first();

        List<Element> products = ul.getElementsByTag("li");
        List<WebScraping> scrapingMagalu = new ArrayList<>();

        for(Element product: products){

            List<Element>attributs = product.getElementsByTag("a");
            WebScraping webScraping = new WebScraping();
            webScraping.setNomeProduto(attributs.get(0).text());
            //webScraping.setValorProduto(attributs.get(1).text());

            scrapingMagalu.add(webScraping);
        }

        return scrapingMagalu;
    }
    */
    public static void main(String[] args) throws IOException {

        //1 - URL do site a ser acessado
        String url = "https://www.magazineluiza.com.br/busca/notebook/?page=1";
        //2 - Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();
        //3 - Obtendo os artigos por classe
        List<Element> artigos = doc.getElementsByClass("sc-cnHmbd dQVIVc");

        List<Element> nome = new ArrayList<>();
        List<String> valor = new ArrayList<>();

        //4 - Obtendo as tags "a" dos artigos
        artigos.forEach(element -> {
            nome.add(element.getElementsByClass("sc-hFxENk fskQXn").first());
        });

        //5 - Obtendo as urls das tags a
        nome.forEach(element -> {
          valor.add(element.attr("sc-hFxENk fskQXn"));
        });
        //6 - Imprimindo os links
        nome.forEach(s -> {
            System.out.println("Produto: "  + s);
        });
    }
/*
    private static void converterToJson(WebScraping webScraping){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(webScraping);
            System.out.println("Objeto em JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }*/
}
