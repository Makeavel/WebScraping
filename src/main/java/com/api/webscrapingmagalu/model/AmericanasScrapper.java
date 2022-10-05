package com.api.webscrapingmagalu.model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.Data;

@Data
public class AmericanasScrapper {
    
    //throws IOException, InterruptedException 
    String baseUrl = "";
    
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    Date date = new Date();

    public AmericanasScrapper(String url){
        this.baseUrl = url;
    }

    public List<Map<String, String>> getAllSmartphoneAM(int pages) throws IOException, InterruptedException {
        // Array para armazenar os produtos.
        List<Map<String, String>> allProducts = new ArrayList<>();
        FileWriter writer = new FileWriter("AmericanasSmartphone.txt" , true);
        for (int i = 1; i <= pages; i++) {
            System.out.println("Fetching the following URL: " + this.baseUrl + ((i-1)*24) + "\n");
            Document doc = Jsoup
                    .connect(this.baseUrl + ((i - 1) * 24))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                    .timeout(30000)
                    .get();

            // Pegar todos os cards de detalhes de produtos da página.
            List<Element> productsElements = doc.select("div[class*=\"inStockCard__Wrapper\"]");
            // Array para armazenar os produtos.
            List<Map<String, String>> products = new ArrayList<>();

            AtomicInteger counter = new AtomicInteger(0);
            // Percorrer todos os 24 cards de produtos obtidos anteriormente.
            productsElements.forEach(prod -> {
                // Pegar o nome de cada produto.
                //class*=\"product-info__Container\"
                String name = prod.select("div[class*=\"product-info__Container\"]>h3[class*=\"product-name\"]").text();
                String price = "";

                // Obter o elemento que fica o valor de cada produto (<p>).
                Element productPriceTag = prod.select("div[class*=\"price-info__Wrapper\"] span").first();
                // Se a tag obtida não for null, significa que o produto tem preço, não está esgotado.
                if (productPriceTag != null) {
                    // Então salvamos esse preço na variável price.
                    price = productPriceTag.text();
                    //System.out.println(name + " - " + price);
                } else {
                    // Se o produto estiver esgotado, obter o valor contido na tag respectiva (Xiii, já foi tudo).
                    price = prod.select("span[class*=\"outOfStockCard\"]").first().text();
                    //System.out.println(name + " - " + price);
                }

                // Criamos um map para armazenar o produto obtido com nome, e preço:
                // Map<String, String>.
                Map<String, String> product = new HashMap<String, String>();
                // Salvamos no map o nome do produto salvo anteriormente.
                product.put("productName", name);
                // Salvamos no map o preço do produto salvo anteriormente.
                product.put("productPrice", price);
                // Adicionamos o produto gerado na lista de produtos.
                products.add(product);

                // // Incrementamos o contador.
                counter.set(counter.get() + 1);
            });

            // Imprime a abertura do divisor de páginas pulando uma linha
            System.out.println("***************************** INÍCIO PÁGINA " + i + " ********************************\n");
            // Reiniciamos o contador.
            counter.set(0);
            products.forEach(prod -> {
                // Printamos cada produto formatado como desejado.

                try{
                    writer.write(( prod.get("productName") + " ; " + prod.get("productPrice") + " ;  Data: " + dateFormat.format(date) + "\n"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Produto " + (counter.get() + 1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));

                // Incrementamos o contador.
                counter.set(counter.get() + 1);
                // Obs: O contador não é necessário para nada, a não ser saber a quantidade
                // de registros que existe na List,
                // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado
                // só pra debugar. Pode ser removido se quiser.
            });

            // Imprime o fechamento do divisor de páginas pulando uma linha
            System.out.println("\n***************************** FIM PÁGINA " + i + " ********************************\n");

            allProducts.addAll(products);

            // // Aguardar 10 segundos antes de prosseguir para a próxima repetição
            TimeUnit.SECONDS.sleep(10);
        }
            writer.close();
        return allProducts;
    }

    public List<Map<String, String>> getAllNotebookAM(int pages) throws IOException, InterruptedException {
        // Array para armazenar os produtos.
        List<Map<String, String>> allProducts = new ArrayList<>();
        FileWriter writer = new FileWriter("AmericanasNotebook.txt" , true);
        for (int i = 1; i <= pages; i++) {
            System.out.println("Fetching the following URL: " + this.baseUrl + ((i-1)*24) + "\n");
            Document doc = Jsoup
                    .connect(this.baseUrl + ((i - 1) * 24))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                    .timeout(30000)
                    .get();

            // Pegar todos os cards de detalhes de produtos da página.
            List<Element> productsElements = doc.select("div[class*=\"inStockCard__Wrapper\"]");
            // Array para armazenar os produtos.
            List<Map<String, String>> products = new ArrayList<>();

            AtomicInteger counter = new AtomicInteger(0);
            // Percorrer todos os 24 cards de produtos obtidos anteriormente.
            productsElements.forEach(prod -> {
                // Pegar o nome de cada produto.
                //class*=\"product-info__Container\"
                String name = prod.select("div[class*=\"product-info__Container\"]>h3[class*=\"product-name\"]").text();
                String price = "";

                // Obter o elemento que fica o valor de cada produto (<p>).
                Element productPriceTag = prod.select("div[class*=\"price-info__Wrapper\"] span").first();
                // Se a tag obtida não for null, significa que o produto tem preço, não está esgotado.
                if (productPriceTag != null) {
                    // Então salvamos esse preço na variável price.
                    price = productPriceTag.text();
                    //System.out.println(name + " - " + price);
                } else {
                    // Se o produto estiver esgotado, obter o valor contido na tag respectiva (Xiii, já foi tudo).
                    price = prod.select("span[class*=\"outOfStockCard\"]").first().text();
                    //System.out.println(name + " - " + price);
                }

                // Criamos um map para armazenar o produto obtido com nome, e preço:
                // Map<String, String>.
                Map<String, String> product = new HashMap<String, String>();
                // Salvamos no map o nome do produto salvo anteriormente.
                product.put("productName", name);
                // Salvamos no map o preço do produto salvo anteriormente.
                product.put("productPrice", price);
                // Adicionamos o produto gerado na lista de produtos.
                products.add(product);

                // // Incrementamos o contador.
                counter.set(counter.get() + 1);
            });

            // Imprime a abertura do divisor de páginas pulando uma linha
            System.out.println("***************************** INÍCIO PÁGINA " + i + " ********************************\n");
            // Reiniciamos o contador.
            counter.set(0);
            products.forEach(prod -> {
                // Printamos cada produto formatado como desejado.

                try{
                    writer.write(( prod.get("productName") + " ; " + prod.get("productPrice") + " ;  Data: " + dateFormat.format(date) + "\n"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Produto " + (counter.get() + 1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));

                // Incrementamos o contador.
                counter.set(counter.get() + 1);
                // Obs: O contador não é necessário para nada, a não ser saber a quantidade
                // de registros que existe na List,
                // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado
                // só pra debugar. Pode ser removido se quiser.
            });

            // Imprime o fechamento do divisor de páginas pulando uma linha
            System.out.println("\n***************************** FIM PÁGINA " + i + " ********************************\n");

            allProducts.addAll(products);

            // // Aguardar 10 segundos antes de prosseguir para a próxima repetição
            TimeUnit.SECONDS.sleep(10);
        }
            writer.close();
        return allProducts;
    }

    public List<Map<String, String>> getAllSmartTVAM(int pages) throws IOException, InterruptedException {
        // Array para armazenar os produtos.
        List<Map<String, String>> allProducts = new ArrayList<>();
        FileWriter writer = new FileWriter("AmericanasTV.txt" , true);
        for (int i = 1; i <= pages; i++) {
            System.out.println("Fetching the following URL: " + this.baseUrl + ((i-1)*24) + "\n");
            Document doc = Jsoup
                    .connect(this.baseUrl + ((i - 1) * 24))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                    .timeout(30000)
                    .get();

            // Pegar todos os cards de detalhes de produtos da página.
            List<Element> productsElements = doc.select("div[class*=\"inStockCard__Wrapper\"]");
            // Array para armazenar os produtos.
            List<Map<String, String>> products = new ArrayList<>();

            AtomicInteger counter = new AtomicInteger(0);
            // Percorrer todos os 24 cards de produtos obtidos anteriormente.
            productsElements.forEach(prod -> {
                // Pegar o nome de cada produto.
                //class*=\"product-info__Container\"
                String name = prod.select("div[class*=\"product-info__Container\"]>h3[class*=\"product-name\"]").text();
                String price = "";

                // Obter o elemento que fica o valor de cada produto (<p>).
                Element productPriceTag = prod.select("div[class*=\"price-info__Wrapper\"] span").first();
                // Se a tag obtida não for null, significa que o produto tem preço, não está esgotado.
                if (productPriceTag != null) {
                    // Então salvamos esse preço na variável price.
                    price = productPriceTag.text();
                    //System.out.println(name + " - " + price);
                } else {
                    // Se o produto estiver esgotado, obter o valor contido na tag respectiva (Xiii, já foi tudo).
                    price = prod.select("span[class*=\"outOfStockCard\"]").first().text();
                    //System.out.println(name + " - " + price);
                }

                // Criamos um map para armazenar o produto obtido com nome, e preço:
                // Map<String, String>.
                Map<String, String> product = new HashMap<String, String>();
                // Salvamos no map o nome do produto salvo anteriormente.
                product.put("productName", name);
                // Salvamos no map o preço do produto salvo anteriormente.
                product.put("productPrice", price);
                // Adicionamos o produto gerado na lista de produtos.
                products.add(product);

                // // Incrementamos o contador.
                counter.set(counter.get() + 1);
            });

            // Imprime a abertura do divisor de páginas pulando uma linha
            System.out.println("***************************** INÍCIO PÁGINA " + i + " ********************************\n");
            // Reiniciamos o contador.
            counter.set(0);
            products.forEach(prod -> {
                // Printamos cada produto formatado como desejado.

                try{
                    writer.write(( prod.get("productName") + " ; " + prod.get("productPrice") + " ;  Data: " + dateFormat.format(date) + "\n"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Produto " + (counter.get() + 1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));

                // Incrementamos o contador.
                counter.set(counter.get() + 1);
                // Obs: O contador não é necessário para nada, a não ser saber a quantidade
                // de registros que existe na List,
                // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado
                // só pra debugar. Pode ser removido se quiser.
            });

            // Imprime o fechamento do divisor de páginas pulando uma linha
            System.out.println("\n***************************** FIM PÁGINA " + i + " ********************************\n");

            allProducts.addAll(products);

            // // Aguardar 10 segundos antes de prosseguir para a próxima repetição
            TimeUnit.SECONDS.sleep(10);
        }
            writer.close();
        return allProducts;
    }

    public List<Map<String, String>> getAllSmartwatchAM(int pages) throws IOException, InterruptedException {
        // Array para armazenar os produtos.
        List<Map<String, String>> allProducts = new ArrayList<>();
        FileWriter writer = new FileWriter("AmericanasSmartwatch.txt" , true);
        for (int i = 1; i <= pages; i++) {
            System.out.println("Fetching the following URL: " + this.baseUrl + ((i-1)*24) + "\n");
            Document doc = Jsoup
                    .connect(this.baseUrl + ((i - 1) * 24))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                    .timeout(30000)
                    .get();

            // Pegar todos os cards de detalhes de produtos da página.
            List<Element> productsElements = doc.select("div[class*=\"inStockCard__Wrapper\"]");
            // Array para armazenar os produtos.
            List<Map<String, String>> products = new ArrayList<>();

            AtomicInteger counter = new AtomicInteger(0);
            // Percorrer todos os 24 cards de produtos obtidos anteriormente.
            productsElements.forEach(prod -> {
                // Pegar o nome de cada produto.
                //class*=\"product-info__Container\"
                String name = prod.select("div[class*=\"product-info__Container\"]>h3[class*=\"product-name\"]").text();
                String price = "";

                // Obter o elemento que fica o valor de cada produto (<p>).
                Element productPriceTag = prod.select("div[class*=\"price-info__Wrapper\"] span").first();
                // Se a tag obtida não for null, significa que o produto tem preço, não está esgotado.
                if (productPriceTag != null) {
                    // Então salvamos esse preço na variável price.
                    price = productPriceTag.text();
                    //System.out.println(name + " - " + price);
                } else {
                    // Se o produto estiver esgotado, obter o valor contido na tag respectiva (Xiii, já foi tudo).
                    price = prod.select("span[class*=\"outOfStockCard\"]").first().text();
                    //System.out.println(name + " - " + price);
                }

                // Criamos um map para armazenar o produto obtido com nome, e preço:
                // Map<String, String>.
                Map<String, String> product = new HashMap<String, String>();
                // Salvamos no map o nome do produto salvo anteriormente.
                product.put("productName", name);
                // Salvamos no map o preço do produto salvo anteriormente.
                product.put("productPrice", price);
                // Adicionamos o produto gerado na lista de produtos.
                products.add(product);

                // // Incrementamos o contador.
                counter.set(counter.get() + 1);
            });

            // Imprime a abertura do divisor de páginas pulando uma linha
            System.out.println("***************************** INÍCIO PÁGINA " + i + " ********************************\n");
            // Reiniciamos o contador.
            counter.set(0);
            products.forEach(prod -> {
                // Printamos cada produto formatado como desejado.

                try{
                    writer.write(( prod.get("productName") + " ; " + prod.get("productPrice") + " ;  Data: " + dateFormat.format(date) + "\n"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Produto " + (counter.get() + 1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));

                // Incrementamos o contador.
                counter.set(counter.get() + 1);
                // Obs: O contador não é necessário para nada, a não ser saber a quantidade
                // de registros que existe na List,
                // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado
                // só pra debugar. Pode ser removido se quiser.
            });

            // Imprime o fechamento do divisor de páginas pulando uma linha
            System.out.println("\n***************************** FIM PÁGINA " + i + " ********************************\n");

            allProducts.addAll(products);

            // // Aguardar 10 segundos antes de prosseguir para a próxima repetição
            TimeUnit.SECONDS.sleep(10);
        }
            writer.close();
        return allProducts;
    }

    public List<Map<String, String>> getAllPlacaDeVideoAM(int pages) throws IOException, InterruptedException {
        // Array para armazenar os produtos.
        List<Map<String, String>> allProducts = new ArrayList<>();
        FileWriter writer = new FileWriter("AmericanasPlacaDeVideo.txt" , true);
        for (int i = 1; i <= pages; i++) {
            System.out.println("Fetching the following URL: " + this.baseUrl + ((i-1)*24) + "\n");
            Document doc = Jsoup
                    .connect(this.baseUrl + ((i - 1) * 24))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                    .timeout(30000)
                    .get();

            // Pegar todos os cards de detalhes de produtos da página.
            List<Element> productsElements = doc.select("div[class*=\"inStockCard__Wrapper\"]");
            // Array para armazenar os produtos.
            List<Map<String, String>> products = new ArrayList<>();

            AtomicInteger counter = new AtomicInteger(0);
            // Percorrer todos os 24 cards de produtos obtidos anteriormente.
            productsElements.forEach(prod -> {
                // Pegar o nome de cada produto.
                //class*=\"product-info__Container\"
                String name = prod.select("div[class*=\"product-info__Container\"]>h3[class*=\"product-name\"]").text();
                String price = "";

                // Obter o elemento que fica o valor de cada produto (<p>).
                Element productPriceTag = prod.select("div[class*=\"price-info__Wrapper\"] span").first();
                // Se a tag obtida não for null, significa que o produto tem preço, não está esgotado.
                if (productPriceTag != null) {
                    // Então salvamos esse preço na variável price.
                    price = productPriceTag.text();
                    //System.out.println(name + " - " + price);
                } else {
                    // Se o produto estiver esgotado, obter o valor contido na tag respectiva (Xiii, já foi tudo).
                    price = prod.select("span[class*=\"outOfStockCard\"]").first().text();
                    //System.out.println(name + " - " + price);
                }

                // Criamos um map para armazenar o produto obtido com nome, e preço:
                // Map<String, String>.
                Map<String, String> product = new HashMap<String, String>();
                // Salvamos no map o nome do produto salvo anteriormente.
                product.put("productName", name);
                // Salvamos no map o preço do produto salvo anteriormente.
                product.put("productPrice", price);
                // Adicionamos o produto gerado na lista de produtos.
                products.add(product);

                // // Incrementamos o contador.
                counter.set(counter.get() + 1);
            });

            // Imprime a abertura do divisor de páginas pulando uma linha
            System.out.println("***************************** INÍCIO PÁGINA " + i + " ********************************\n");
            // Reiniciamos o contador.
            counter.set(0);
            products.forEach(prod -> {
                // Printamos cada produto formatado como desejado.

                try{
                    writer.write(( prod.get("productName") + " ; " + prod.get("productPrice") + " ;  Data: " + dateFormat.format(date) + "\n"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Produto " + (counter.get() + 1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));

                // Incrementamos o contador.
                counter.set(counter.get() + 1);
                // Obs: O contador não é necessário para nada, a não ser saber a quantidade
                // de registros que existe na List,
                // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado
                // só pra debugar. Pode ser removido se quiser.
            });

            // Imprime o fechamento do divisor de páginas pulando uma linha
            System.out.println("\n***************************** FIM PÁGINA " + i + " ********************************\n");

            allProducts.addAll(products);

            // // Aguardar 10 segundos antes de prosseguir para a próxima repetição
            TimeUnit.SECONDS.sleep(10);
        }
            writer.close();
        return allProducts;
    }


}
