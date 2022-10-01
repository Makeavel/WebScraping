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
                dinheiro.add(element.getElementsByClass("sc-crHmcD bKgmQY sc-hGnimi ddEjGv").first());
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
