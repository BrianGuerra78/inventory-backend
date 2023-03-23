package com.bguerra.inventory.controller;

import com.bguerra.inventory.model.Product;
import com.bguerra.inventory.response.ProductResponseRest;
import com.bguerra.inventory.services.IProductService;
import com.bguerra.inventory.util.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

    private IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseRest> save(@RequestParam("picture") MultipartFile picture, @RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("account") int account, @RequestParam("categoryId") Long categoryID) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setAccount(account);
        product.setPrice(price);
        product.setPicture(Util.compressZLib(picture.getBytes()));//compresion de foto

        ResponseEntity<ProductResponseRest> response = productService.save(product, categoryID);
        return response;
    }

    @GetMapping("/products/{id}")//search by id
    public ResponseEntity<ProductResponseRest> searchById(@PathVariable Long id) {
        ResponseEntity<ProductResponseRest> response = productService.searchById(id);
        return response;
    }

    @GetMapping("/products/filter/{name}")//search by id
    public ResponseEntity<ProductResponseRest> searchByName(@PathVariable String name) {
        ResponseEntity<ProductResponseRest> response = productService.searchByName(name);
        return response;
    }

    @DeleteMapping("/products/{id}")//delete by id
    public ResponseEntity<ProductResponseRest> deleteById(@PathVariable Long id) {
        ResponseEntity<ProductResponseRest> response = productService.deleteById(id);
        return response;
    }

    @GetMapping("/products")//search by id
    public ResponseEntity<ProductResponseRest> search() {
        ResponseEntity<ProductResponseRest> response = productService.search();
        return response;
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> update(@RequestParam("picture") MultipartFile picture,
                                                      @RequestParam("name") String name,
                                                      @RequestParam("price") int price,
                                                      @RequestParam("account") int account,
                                                      @RequestParam("categoryId") Long categoryID,
                                                      @PathVariable Long id) throws IOException {

        Product product = new Product();
        product.setName(name);
        product.setAccount(account);
        product.setPrice(price);
        product.setPicture(Util.compressZLib(picture.getBytes()));

        ResponseEntity<ProductResponseRest> response = productService.update(product, categoryID, id);
        return response;
    }
}
