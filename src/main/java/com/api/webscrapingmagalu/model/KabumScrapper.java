package com.api.webscrapingmagalu.model;

public class KabumScrapper {
    

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
