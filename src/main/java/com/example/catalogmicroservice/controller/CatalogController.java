package com.example.catalogmicroservice.controller;

import com.example.catalogmicroservice.entity.CatalogEntity;
import com.example.catalogmicroservice.service.CatalogService;
import com.example.catalogmicroservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalog-service")
public class CatalogController {

    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String status(){
        return "It's working in catalog service on port : " +env.getProperty("local.server.port");
    }

    @GetMapping("/catalogs")
    public List<ResponseCatalog> getCatalogs(){
        List<CatalogEntity> userList = catalogService.getAllCatalogs();
        List<ResponseCatalog> result = new ArrayList<>();

        userList.forEach(v-> result.add(new ModelMapper().map(v, ResponseCatalog.class))
        );
        return result;
    }
}
