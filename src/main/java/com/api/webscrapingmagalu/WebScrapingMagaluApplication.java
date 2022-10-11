package com.api.webscrapingmagalu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.api.webscrapingmagalu.model.AmericanasScrapper;
import com.api.webscrapingmagalu.model.MagaluScrapper;
import java.io.IOException;

@SpringBootApplication
public class WebScrapingMagaluApplication {

    public static void main(String[] args) throws IOException, InterruptedException {


//            -----------------------  Magazine Luiza  --------------------
        MagaluScrapper scrapperTVMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smart+tv/?page=");
        scrapperTVMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluTV.txt");

        MagaluScrapper scrapperSmartphoneMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smartphone/?page=");
        scrapperSmartphoneMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluSmartphone.txt");
   
        MagaluScrapper scrapperNotebookMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/notebook/?page=");
        scrapperNotebookMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluNotebook.txt");

        MagaluScrapper scrapperWatchMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smart+watch/?page=");
        scrapperWatchMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluSmartwatch.txt");

        MagaluScrapper scrapperPlacaVideoMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/placa+de+video/?page=");
        scrapperPlacaVideoMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluPlacaDevideo.txt");

//              -----------------------  Lojas Americanas  --------------------

        AmericanasScrapper scrapperSmartphoneAM = new AmericanasScrapper("https://www.americanas.com.br/categoria/celulares-e-smartphones/smartphone/g/tipo-de-produto-Celular/tipo-de-produto-Iphone/tipo-de-produto-Smartphone?chave=pfm_hm_tt_1_0_smartphone&viewMode=grid&limit=24&offset=");
        scrapperSmartphoneAM.getAllProductAM(1, 20 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasSmartphone.txt");

        AmericanasScrapper scrapperNotebookAM = new AmericanasScrapper("https://www.americanas.com.br/busca/notebook?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&content=notebook&filter=%7B'id'%3A'categoria'%2C'value'%3A'Informática'%2C'fixed'%3Afalse%7D&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
        scrapperNotebookAM.getAllProductAM(1, 20 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasNotebook.txt");

        AmericanasScrapper scrapperSmartwatchAM = new AmericanasScrapper("https://www.americanas.com.br/busca/smartwatch?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&content=smartwatch&filter=%7B'id'%3A'categoria'%2C'value'%3A'Smartwatch'%2C'fixed'%3Afalse%7D&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
        scrapperSmartwatchAM.getAllProductAM(1, 10 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasSmartwatch.txt");

        AmericanasScrapper scrapperTVAM = new AmericanasScrapper("https://www.americanas.com.br/busca/smart-tv?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&content=smart%20tv&filter=%7B'id'%3A'categoria'%2C'value'%3A'TV%20e%20Home%20Theater'%2C'fixed'%3Afalse%7D&filter=%7B'id'%3A'categoria'%2C'value'%3A'TV%20e%20Home%20Theater%7CTV'%2C'fixed'%3Afalse%7D&filter=%7B'id'%3A'condicao'%2C'value'%3A'novo'%2C'fixed'%3Afalse%7D&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
        scrapperTVAM.getAllProductAM(1, 10 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasTV.txt" );

        AmericanasScrapper scrapperPlacaDeVIdeoAM = new AmericanasScrapper("https://www.americanas.com.br/busca/placa-de-video?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&content=placa%20de%20video&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
        scrapperPlacaDeVIdeoAM.getAllProductAM(1, 20 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasPlacaDeVideo.txt");

        // DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // Date date = new Date();

        // // mudar para i <= 83
        // for (int i = 1; i <= 83; i++) {

        //     // Tests Silvio.
        //     //String url = "https://www.americanas.com.br/categoria/celulares-e-smartphones/smartphone?chave=pfm_hm_tt_1_0_smartphone&viewMode=grid&limit=24&offset="+((i-1)*24);
        //     String url = "https://www.americanas.com.br/categoria/celulares-e-smartphones/smartphone/g/tipo-de-produto-Celular/tipo-de-produto-Iphone/tipo-de-produto-Smartphone?chave=pfm_hm_tt_1_0_smartphone&viewMode=grid&limit=24&offset="+((i-1)*24);
        //     System.out.println(url);
        //     Document doc = Jsoup
        //             .connect(url)
        //             .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
        //             .timeout(30000)
        //             .get();

        //     // Pegar todos os cards de detalhes de produtos da página.
        //     List<Element> productsElements = doc.select("div[class*=\"inStockCard__Wrapper\"]");
        //     // Array para armazenar os produtos.
        //     List<Map<String, String>> products = new ArrayList<>();

        //     AtomicInteger counter = new AtomicInteger(0);
        //     // Percorrer todos os 24 cards de produtos obtidos anteriormente.
        //     productsElements.forEach(prod -> {
        //         // Pegar o nome de cada produto.
        //         //class*=\"product-info__Container\"
        //         String name = prod.select("div[class*=\"product-info__Container\"]>h3[class*=\"product-name\"]").text();
        //         String price = "";

        //         // Obter o elemento que fica o valor de cada produto (<p>).
        //         Element productPriceTag = prod.select("div[class*=\"price-info__Wrapper\"] span").first();
        //         // Se a tag obtida não for null, significa que o produto tem preço, não está esgotado.
        //         if (productPriceTag != null) {
        //             // Então salvamos esse preço na variável price.
        //             price = productPriceTag.text();
        //             //System.out.println(name + " - " + price);
        //         } else {
        //             // Se o produto estiver esgotado, obter o valor contido na tag respectiva (Xiii, já foi tudo).
        //             price = prod.select("span[class*=\"outOfStockCard\"]").first().text();
        //             //System.out.println(name + " - " + price);
        //         }

        //         // Criamos um map para armazenar o produto obtido com nome, e preço:
        //         // Map<String, String>.
        //         Map<String, String> product = new HashMap<String, String>();
        //         // Salvamos no map o nome do produto salvo anteriormente.
        //         product.put("productName", name);
        //         // Salvamos no map o preço do produto salvo anteriormente.
        //         product.put("productPrice", price);
        //         // Adicionamos o produto gerado na lista de produtos.
        //         products.add(product);

        //         // // Incrementamos o contador.
        //         counter.set(counter.get() + 1);
        //     });

        //     // Imprime a abertura do divisor de páginas pulando uma linha
        //     System.out.println("***************************** INÍCIO PÁGINA " + i + " ********************************\n");
        //     // Reiniciamos o contador.
        //     counter.set(0);
        //     products.forEach(prod -> {
        //         // Printamos cada produto formatado como desejado.

        //         System.out.println("Produto " + (counter.get() + 1) + ": " + prod.get("productName") + " || " + prod.get("productPrice") + " || Data: " + dateFormat.format(date));

        //         // Incrementamos o contador.
        //         counter.set(counter.get() + 1);
        //         // Obs: O contador não é necessário para nada, a não ser saber a quantidade
        //         // de registros que existe na List,
        //         // que será sempre (counter + 1), já que inicia no índex 0 da List. Foi usado
        //         // só pra debugar. Pode ser removido se quiser.
        //     });

        //     // Imprime o fechamento do divisor de páginas pulando uma linha
        //     System.out.println("\n***************************** FIM PÁGINA " + i + " ********************************\n");

        //     // // Aguardar 10 segundos antes de prosseguir para a próxima repetição
        //     TimeUnit.SECONDS.sleep(10);
        // }
    }

}

