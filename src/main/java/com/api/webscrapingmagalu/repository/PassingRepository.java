package com.api.webscrapingmagalu.repository;

import com.api.webscrapingmagalu.model.WebScraping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassingRepository extends JpaRepository<WebScraping, String> {


}
