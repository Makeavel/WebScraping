package com.api.webscrapingmagalu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.api.webscrapingmagalu.model.AmericanasScrapper;
import com.api.webscrapingmagalu.model.MagaluScrapper;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class WebScrapingMagaluApplication {
    
    

    public static void main(String[] args ) throws IOException, InterruptedException {

         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
         Date date = new Date();

//             -----------------------  Lojas Americanas  --------------------

      //  AmericanasScrapper scrapperTVAM = new AmericanasScrapper("https://www.americanas.com.br/busca/smart-tv?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&content=smart%20tv&filter=%7B'id'%3A'categoria'%2C'value'%3A'TV%20e%20Home%20Theater'%2C'fixed' %3Afalse%7D&filter=%7B'id'%3A'categoria'%2C'value'%3A'TV%20e%20Home%20Theater%7CTV'%2C'fixed'%3Afalse%7D&filter=%7B'id'%3A'condicao'%2C'value'%3A'novo'%2C'fixed'%3Afalse%7D&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
      //  scrapperTVAM.getAllProductAM(1, 10 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasTV-" + dateFormat.format(date) +".txt" );

        MagaluScrapper scrapperTVMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smart+tv/?page=");
        scrapperTVMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluTV-" + dateFormat.format(date) +".txt");

        //AmericanasScrapper scrapperSmartphoneAM = new AmericanasScrapper("https://www.americanas.com.br/categoria/celulares-e-smartphones/smartphone/g/tipo-de-produto-Celular/tipo-de-produto-Iphone/tipo-de-produto-Smartphone?chave=pfm_hm_tt_1_0_smartphone&viewMode=grid&limit=24&offset=");
        //scrapperSmartphoneAM.getAllProductAM(1, 20 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasSmartphone.txt");

        AmericanasScrapper scrapperNotebookAM = new AmericanasScrapper("https://www.americanas.com.br/busca/notebook?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&content=notebook&filter=%7B'id'%3A'categoria'%2C'value'%3A'Inform??tica'%2C'fixed'%3Afalse%7D&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
        scrapperNotebookAM.getAllProductAM(1, 20 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasNotebook-" + dateFormat.format(date) +".txt");

        AmericanasScrapper scrapperSmartwatchAM = new AmericanasScrapper("https://www.americanas.com.br/busca/smartwatch?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&content=smartwatch&filter=%7B'id'%3A'categoria'%2C'value'%3A'Smartwatch'%2C'fixed'%3Afalse%7D&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
        scrapperSmartwatchAM.getAllProductAM(1, 10 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasSmartwatch-" + dateFormat.format(date) +".txt");

        AmericanasScrapper scrapperSmartphoneAM = new AmericanasScrapper("https://www.americanas.com.br/categoria/celulares-e-smartphones/smartphone/g/tipo-de-produto-Celular/tipo-de-produto-Iphone/tipo-de-produto-Smartphone?chave=pfm_hm_tt_1_0_smartphone&viewMode=grid&limit=24&offset=");
        scrapperSmartphoneAM.getAllProductAM(1, 20 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasSmartphone-" + dateFormat.format(date) +".txt");

        AmericanasScrapper scrapperPlacaDeVIdeoAM = new AmericanasScrapper("https://www.americanas.com.br/busca/placa-de-video?c_legionRegion=995301&c_macroRegion=MIDWEST_INTERIOR&c_mesoRegion=5301&cotent=placa%20de%20video&sortBy=relevance&source=nanook&testab=searchTestAB%3Dnew&limit=24&offset=");
        scrapperPlacaDeVIdeoAM.getAllProductAM(1, 20 , "src/main/java/com/api/webscrapingmagalu/files/AmericanasPlacaDeVideo-" + dateFormat.format(date) +".txt");


//            -----------------------  Magazine Luiza  --------------------

                        
        MagaluScrapper scrapperWatchMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smart+watch/?page=");
        scrapperWatchMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluSmartwatch-" + dateFormat.format(date) +".txt");
            
        MagaluScrapper scrapperPlacaVideoMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/placa+de+video/?page=");
        scrapperPlacaVideoMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluPlacaDevideo-" + dateFormat.format(date) +".txt");

        MagaluScrapper scrapperNotebookMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/notebook/?page=");
        scrapperNotebookMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluNotebook-" + dateFormat.format(date) +".txt");

        MagaluScrapper scrapperSmartphoneMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smartphone/?page=");
        scrapperSmartphoneMG.getAllProductMagalu(1, 17 , "src/main/java/com/api/webscrapingmagalu/files/MagaluSmartphone-" + dateFormat.format(date) +".txt");
             

    }

}

