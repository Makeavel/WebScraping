package com.api.webscrapingmagalu.service;

import com.api.webscrapingmagalu.WebScrapingMagaluApplication;
import com.api.webscrapingmagalu.model.WebScraping;
import com.api.webscrapingmagalu.repository.PassingRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WebCrapingService {

    @Autowired
    PassingRepository repository;

    /*public void extrairDados() throws IOException {
        List<WebScraping> passers = WebScrapingMagaluApplication.extrairDados();

        for (WebScraping p: passers){
            System.out.println("salvando o qb " + p.getNomeProduto());
            repository.save(p);
        }
    }*/
}
