package com.api.webscrapingmagalu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class WebScrapingMagaluApplication {

    public static void main(String[] args) throws IOException {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    //int i = 1;
    for(int j = 1; j<=17;j++){
        
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

        //4 - Obtendo as tags/classses dos artigos
            artigos.forEach(element -> {
                nome.add(element.getElementsByTag("h2").first());                   
            });

            valorProduto.forEach(element ->{
                dinheiro.add(element.getElementsByClass("sc-crHmcD cUbEYF sc-iukxot cqVUBD").first());
            });

        //5 - Obtendo o conteudo das tags 
            nome.forEach(element -> {
                valor.add(element.attr("sc-hFxENk fskQXn")); //h2
            });

            valorProduto.forEach(element -> {
                listDinheiro.add(element.attr("sc-hFxENk fskQXn")); // <p  preco-value
            });
        //6 - Imprimindo os links
            int count = 0;
            nome.forEach(s -> {
                
               System.out.println("Produto: "  + s.text() +  " || Valor: "+ dinheiro.listIterator(0) + "  || Data: " + dateFormat.format(date));
                
            });  
            valorProduto.forEach(p ->{
                //System.out.println("Valor: " + p.text());
            });
            
            //for(int in = 0; in <= nome.size() ; in++){
             //   System.out.println("Produto: "  + nome.get(in).text() +  " || Valor: "+ dinheiro.get(in).text() + "  || Data: " + dateFormat.format(date));
            //}
            
    }
}

   


}
