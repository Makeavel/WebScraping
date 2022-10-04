package com.api.webscrapingmagalu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class WebScrapingMagaluApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    int i = 1;
     for (int j = 11; j <= 17; j++) {

    //     //1 - URL do site a ser acessado
    //     //String url = "https://www.magazineluiza.com.br/busca/smartphone/?page="+j;
    //     //2 - Conectando e obtendo uma cópia do html inteiro da página
    //     //Document doc = Jsoup.connect(url).timeout(30000).get();
    //     // //3 - Obtendo os artigos por classe
    //     // List<Element> artigos = doc.getElementsByClass("sc-cnHmbd dQVIVc");
    //     // List<Element> valorProduto = doc.getElementsByClass("sc-hKwDye iKLUrB sc-itWPBs jrSJVN");
    //     // List<Element> produtoEsgotado = doc.select("div ul li a div h2 ~ div:last-child span");
        
    //     // List<Element> nome = new ArrayList<>();
    //     // List<String> valor = new ArrayList<>();

    //     // List<Element> dinheiro = new ArrayList<>();
    //     // List<String> listDinheiro = new ArrayList<>();

    //     // List<Element> esgotado = new ArrayList<>();
    //     // List<String> listEsgotado = new ArrayList<>();

    //     // produtoEsgotado.forEach(pe -> {
    //     //     esgotado.add(pe);
    //     // });

    //     // esgotado.forEach(le -> {
    //     //     listEsgotado.add(le.text());
    //     // });

    //     // dinheiro.con

    //     // //4 - Obtendo as tags/classses dos artigos
    //     //     artigos.forEach(element -> {
    //     //         nome.add(element.getElementsByTag("h2").first());                   
    //     //     });

    //     //     valorProduto.forEach(element -> {
    //     //         dinheiro.add(element.getElementsByClass("sc-crHmcD cUbEYF sc-iukxot cqVUBD").first());
    //     //     });

    //     // //5 - Obtendo o conteudo das tags 
    //     //     nome.forEach(element -> {
    //     //         valor.add(element.attr("sc-hFxENk fskQXn")); //h2
    //     //     });

    //     //     valorProduto.forEach(element -> {
    //     //         listDinheiro.add(element.attr("sc-hFxENk fskQXn")); // <p  preco-value
    //     //     });



    //     // //6 - Imprimindo os links
    //     // AtomicInteger ordinal = new AtomicInteger(0);

    //     //     // nome.forEach(s -> {
                
    //     //     //     //System.out.println("Produto " + (ordinal.get()+1) + ": "  + s.text() +   " || Data: " + dateFormat.format(date));
    //     //     //     System.out.println("Produto " + ordinal.get() + ": "  + s.text() +  " || Valor: "+ valorProduto.get(0).text() + " || Data: " + dateFormat.format(date));
    //     //     //     ordinal.set(ordinal.get()+1);
    //     //     // });  

    //     //     // valorProduto.forEach(p ->{
    //     //     //     System.out.println("Index: " + ordinal.get() + " Valor: " + p.text());
    //     //     //     ordinal.set(ordinal.get()+1);
    //     //     // });
           
    //     //     System.out.println("*****************************"+j + "********************************");
    //     //     TimeUnit.SECONDS.sleep(5);
    //     //     //for(int in = 0; in <= nome.size() ; in++){  " || Valor: "+  dinheiro.get(0).text() +
    //     //      //   System.out.println("Produto: "  + nome.get(in).text() +  " || Valor: "+ dinheiro.get(in).text() + "  || Data: " + dateFormat.format(date));
    //     //     //}

        
    //     // Tests Silvio.

         String url = "https://www.magazineluiza.com.br/busca/smart+tv/?page="+j;
         Document doc = Jsoup.connect(url).timeout(30000).get();

           // Pegar todos os cards de detalhes de produtos da página.
         List<Element> productsElements = doc.select("div[data-testid=\"product-card-content\"]");
    //     // Array para armazenar os produtos.
         List<Map<String, String>> products = new ArrayList<>();

         AtomicInteger counter = new AtomicInteger(0);
    //     // Percorrer todos os 60 cards de produtos obtidos anteriormente.
        productsElements.forEach(prod -> {
    //         // Pegar o nome de cada produto.
            String name = prod.select("h2[data-testid=\"product-title\"]").text();
            String price = "";

    //         // Obter o elemento que fica o valor de cada produto (<p>).
             Element productPriceTag = prod.select("p[data-testid=\"price-value\"]").first();
    //         // Se a tag obtida não for null, significa que o produto tem preço, não está esgotado.
            if(productPriceTag != null){
    //             // Então salvamos esse preço na variável price.
                 price = productPriceTag.text();
             }
            else{
    //             // Se o produto estiver esgotado, obter o valor contido na tag respectiva (Xiii, já foi tudo).
                 price = prod.select("div[data-testid=\"price-unavailable\"]").first().text();
             }
            
    //         // Criamos um map para armazenar o produto obtido com nome, e preço: Map<String, String>.
             Map<String, String> product = new HashMap<String, String>();
    //         // Salvamos no map o nome do produto salvo anteriormente.
            product.put("productName", name);
    //         // Salvamos no map o preço do produto salvo anteriormente.
             product.put("productPrice", price);
    //         // Adicionamos o produto gerado na lista de produtos.
             products.add(product);

    //         // Incrementamos o contador.
             counter.set(counter.get()+1);
         });

    //     // Imprime a abertura do divisor de páginas pulando uma linha
         System.out.println("***************************** INÍCIO PÁGINA " + j + " ********************************\n");
    //     // Reiniciamos o contador.
         counter.set(0);
         products.forEach(prod -> {
    //         // Printamos cada produto formatado como desejado.
            

             System.out.println("Produto " + (counter.get()+1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));
                
    // Incrementamos o contador.
             counter.set(counter.get() + 1);
    //         // Obs: O contador não é necessário para nada, a não ser saber a quantidade de registros que existe na List,
    //         // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado só pra debugar. Pode ser removido se quiser.
         });

    //     // Imprime o fechamento do divisor de páginas pulando uma linha
         System.out.println("\n***************************** FIM PÁGINA " + j + " ********************************\n");
            
    //     // Aguardar 5 segundos antes de prosseguir para a próxima repetição
         TimeUnit.SECONDS.sleep(5);
        }
     
    //for (int i = 1; i <= 44; i++) {
        // Kabum
    //    String url = "https://www.kabum.com.br/celular-smartphone/smartphones?page_number=" + i + "&page_size=100&facet_filters=&sort=most_searched";
        //Document doc = Jsoup.connect(url).timeout(30000).get();
    //    String doc = Jsoup.connect(url)
    //          .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		// 	    .header("Accept-Encoding", "gzip, deflate, sdch")
        //         .header("Content-Type","text/html; charset=utf-8")
        //         .header("ETag", "8l9ytuftot1dr5z")
        //         .header("Server", "openresty")
        //         .header("Strict-Transport-Security"," max-age=15552000")
        //         .header("X-Amz-Cf-Pop", "GRU3-P3")
        //         .header("X-Cache", "Miss from cloudfront")
        //         .header("Set-Cookie", "isMobile=false; Path=/")
        //         .header("Set-Cookie", "isMobileDevice=false; Path=/")
        //         .header("X-Amz-Cf-Id", "oeYEslYk12CfnFfryRW30ojDWzoly7Wo6CAQASpvzpn1yr8Uehc5Kg==")
        //         .header("Via", "1.1 8483ff61cdcccba24d8cc9aa8872a810.cloudfront.net")
        //         .header("X-Powered-By", "Next.js")
        //         .header("Vary", "Accept-Encoding")
        //         .header("Transfer-Encoding", "chunked")
        //         .header("Cache-Control", "private, no-cache, no-store, max-age=0, must-revalidate")
        //         .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")
        //         .referrer("http://www.google.com")
                
        //         .timeout(30000)
        //         .get()
        //         .connection()
        //         .response()
        //         .body();
        // System.out.println(doc);
        
    
        // // Pegar todos os cards de detalhes de produtos da página.
        // List<Element> productsElements = doc.select("div[data-testid=\"product-card-content\"]");
        // // Array para armazenar os produtos.
        // List<Map<String, String>> products = new ArrayList<>();

        // AtomicInteger counter = new AtomicInteger(0);
        // // Percorrer todos os 100 cards de produtos obtidos anteriormente.
        // productsElements.forEach(prod -> {
        //     // Pegar o nome de cada produto.
        //     String name = prod.select(".nameCard").text();
        //     // Obter o preço do produto
        //     String price = prod.select(".priceCard").first().text();
            
        //     // Criamos um map para armazenar o produto obtido com nome, e preço: Map<String, String>.
        //     Map<String, String> product = new HashMap<String, String>();
        //     // Salvamos no map o nome do produto salvo anteriormente.
        //     product.put("productName", name);
        //     // Salvamos no map o preço do produto salvo anteriormente.
        //     product.put("productPrice", price);
        //     // Adicionamos o produto gerado na lista de produtos.
        //     products.add(product);

        //     // Incrementamos o contador.
        //     counter.set(counter.get()+1);
        // });

        // // Imprime a abertura do divisor de páginas pulando uma linha
        // System.out.println("***************************** INÍCIO PÁGINA " + i + " ********************************\n");
        // // Reiniciamos o contador.
        // counter.set(0);
        // products.forEach(prod -> {
        //     // Printamos cada produto formatado como desejado.
        //     System.out.println("Produto " + (counter.get()+1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));
        //     // Incrementamos o contador.
        //     counter.set(counter.get() + 1);
        //     // Obs: O contador não é necessário para nada, a não ser saber a quantidade de registros que existe na List,
        //     // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado só pra debugar. Pode ser removido se quiser.
        // });

        // // Imprime o fechamento do divisor de páginas pulando uma linha
        // System.out.println("\n***************************** FIM PÁGINA " + i + " ********************************\n");
        // // Aguardar 5 segundos antes de prosseguir para a próxima repetição
        // TimeUnit.SECONDS.sleep(5);
    }
}

   


//}
