package com.example.catalogmicroservice.service;

import com.example.catalogmicroservice.entity.CatalogEntity;

import java.util.List;

public interface CatalogService {
    List<CatalogEntity> getAllCatalogs();
}
