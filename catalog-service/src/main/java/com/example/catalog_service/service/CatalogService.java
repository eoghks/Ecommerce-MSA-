package com.example.catalog_service.service;

import com.example.catalog_service.entity.CatalogEntity;

import java.util.List;

public interface CatalogService {
    List<CatalogEntity> getAllCatalogs();
}
