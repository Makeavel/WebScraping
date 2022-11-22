package com.api.webscrapingmagalu.model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.Data;

@Data
public class MagaluScrapper {
    
    private String baseUrl = "";
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date date = new Date();

    public MagaluScrapper(String url){
        this.baseUrl = url;
    }

    public List<Map<String, String>> getAllProductMagalu (int inicio , int pages , String route) throws IOException, InterruptedException {
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        FileWriter write = new FileWriter(route, true);

     for (int j = inicio; j <= pages; j++) {

         String url = this.baseUrl+j;
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
            try {
                write.write((prod.get("productName") + " ; " + prod.get("productPrice") + " ;" + dateFormat.format(date) + "; Magazine" + "\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }   
            System.out.println("Produto " + (counter.get()+1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));
            
    // Incrementamos o contador.
             counter.set(counter.get() + 1);
    //         // Obs: O contador não é necessário para nada, a não ser saber a quantidade de registros que existe na List,
    //         // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado só pra debugar. Pode ser removido se quiser.
         });

         // Imprime o fechamento do divisor de páginas pulando uma linha
         System.out.println("\n***************************** FIM PÁGINA " + j + " Magalu ********************************\n");
  
        // Aguardar 5 segundos antes de prosseguir para a próxima repetição
         TimeUnit.SECONDS.sleep(9);
        }
        write.close();
        return null;
    }

 
}
