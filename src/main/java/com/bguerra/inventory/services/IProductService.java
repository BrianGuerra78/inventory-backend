package com.bguerra.inventory.services;

import com.bguerra.inventory.model.Product;
import com.bguerra.inventory.response.ProductResponseRest;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    public ResponseEntity<ProductResponseRest> save(Product product,Long categoryID);

    public ResponseEntity<ProductResponseRest> searchById(Long id);

    public ResponseEntity<ProductResponseRest> searchByName(String name);
}
