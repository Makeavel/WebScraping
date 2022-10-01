package com.api.webscrapingmagalu.service;


public class ScrapingHtmlService {
/* 
    int count = 0;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    //int i = 1;
    for(int j = 1; j<=1;j++){
        
        //1 - URL do site a ser acessado
        String url = "https://www.magazineluiza.com.br/busca/smartphone/?page="+j;
        //2 - Conectando e obtendo uma cópia do html inteiro da página
        Document doc = Jsoup.connect(url).get();
        //3 - Obtendo os artigos por classe
        List<Element> artigos = doc.getElementsByClass("sc-cnHmbd dQVIVc");
        List<Element> valorProduto = doc.getElementsByClass("sc-hKwDye iKLUrB sc-itWPBs jrSJVN");
        List<Element> nome = new ArrayList<>();
        List<Element> dinheiro = new ArrayList<>();
        List<String> valor = new ArrayList<>();
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
                
               System.out.println("Produto: "  + s +  "\n Valor: "+ dinheiro.get(count) + "" + dateFormat.format(date));
                
            });  
            
           
        }
*/
}

