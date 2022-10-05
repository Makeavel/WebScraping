package com.api.webscrapingmagalu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.api.webscrapingmagalu.model.MagaluScrapper;
import java.io.IOException;

@SpringBootApplication
public class WebScrapingMagaluApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

    MagaluScrapper scrapperTVMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smart+tv/?page=");
    scrapperTVMG.getAllSmartTV(17);

    MagaluScrapper scrapperSmartphoneMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smartphone/?page=");
    scrapperSmartphoneMG.getAllSmartphone(17);

    MagaluScrapper scrapperNotebookMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/notebook/?page=");
    scrapperNotebookMG.getAllNotebook(17);

    MagaluScrapper scrapperWatchMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/smart+watch/?page=");
    scrapperWatchMG.getAllSmartwatch(17);

    MagaluScrapper scrapperPlacaVideoMG = new MagaluScrapper("https://www.magazineluiza.com.br/busca/placa+de+video/?page=");
    scrapperPlacaVideoMG.getAllPlacaDeVideo(17);


    }

}

