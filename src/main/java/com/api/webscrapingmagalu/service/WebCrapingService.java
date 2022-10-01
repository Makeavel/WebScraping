package com.api.webscrapingmagalu.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.webscrapingmagalu.WebScrapingMagaluApplication;
import com.api.webscrapingmagalu.model.WebScraping;
import com.api.webscrapingmagalu.repository.PassingRepository;



@Service
public class WebCrapingService {

    

    @Autowired
    PassingRepository repository;

    public void extrairDados() throws IOException {
        List<WebScraping> passers = WebScrapingMagaluApplication.extrairDados();

        for (WebScraping p: passers){
            System.out.println("Produto: " + p.getNomeProduto() + "||" + p.getValorProduto());
            repository.save(p);
        }
    }

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


