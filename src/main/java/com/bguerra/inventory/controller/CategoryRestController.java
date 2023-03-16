package com.bguerra.inventory.controller;

import com.bguerra.inventory.response.CategoryResponseRest;
import com.bguerra.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;

    @GetMapping("/categories")// get all the categories
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }

    @GetMapping("/categories/{id}")//get categori by id
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }

}
