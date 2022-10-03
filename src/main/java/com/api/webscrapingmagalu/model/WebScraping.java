package com.api.webscrapingmagalu.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebScraping {

    private String nomeProduto;
    //private String valorProduto;
    private List<String> valor = new ArrayList<>();
    private List<String> listDinheiro = new ArrayList<>();
    

    public void SmartphoneScraping() throws IOException{
   
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    //int i = 1;
    for(int j = 1; j<=17;j++){
        
        //1 - URL do site acessado
        String url = "https://www.magazineluiza.com.br/busca/smartphone/?page="+j;
        //2 - Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();
        //3 - Obtendo os artigos por classe
        List<Element> artigos = doc.getElementsByClass("sc-cnHmbd dQVIVc");
        List<Element> valorProduto = doc.getElementsByClass("sc-hKwDye iKLUrB sc-itWPBs jrSJVN");
        
        List<Element> nome = new ArrayList<>();
        //List<String> valor = new ArrayList<>();

        List<Element> dinheiro = new ArrayList<>();
        //List<String> listDinheiro = new ArrayList<>();

        //4 - Obtendo as tags/classses dos artigos
            artigos.forEach(element -> {
                nome.add(element.getElementsByTag("h2").first());                   
            });

            valorProduto.forEach(element ->{
                dinheiro.add(element.getElementsByClass("sc-crHmcD cUbEYF sc-iukxot cqVUBD").first());
            });

        //5 - Obtendo o conteudo das tags 
            nome.forEach(element -> {
                this.valor.add(element.attr("sc-hFxENk fskQXn"));
            });

            valorProduto.forEach(element -> {
                this.listDinheiro.add(element.attr("sc-hFxENk fskQXn"));
            });
    }
        for(int in = 0; in <= this.valor.size() ; in++){
           // System.out.println("Produto: "  + nome.get(in).text() +  " || Valor: "+ dinheiro.get(in).text() + "  || Data: " + dateFormat.format(date));
        }
    }

    public void NotebookScraping() throws IOException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        for(int j = 1; j<=17;j++){

            String url = "https://www.magazineluiza.com.br/busca/notebook/?page="+j;
            //2 - Conectando e obtendo uma cópia do html inteiro da página
            Document doc = Jsoup.connect(url).get();
            //3 - Obtendo os artigos por classe
            List<Element> artigos = doc.getElementsByClass("sc-cnHmbd dQVIVc");
            List<Element> valorProduto = doc.getElementsByClass("sc-hKwDye iKLUrB sc-itWPBs jrSJVN");
            
            List<Element> nome = new ArrayList<>();
                
            List<Element> dinheiro = new ArrayList<>();

            //4 - Obtendo as tags/classses dos artigos
            artigos.forEach(element -> {
                nome.add(element.getElementsByTag("h2").first());                   
            });

            valorProduto.forEach(element ->{
                dinheiro.add(element.getElementsByClass("sc-crHmcD cUbEYF sc-iukxot cqVUBD").first());
            });

            nome.forEach(element -> {
                this.valor.add(element.attr("sc-hFxENk fskQXn"));
            });

            valorProduto.forEach(element -> {
                this.listDinheiro.add(element.attr("sc-hFxENk fskQXn"));
            });

        }
    }

}
