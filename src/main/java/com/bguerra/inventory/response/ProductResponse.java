package com.bguerra.inventory.response;

import com.bguerra.inventory.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    List<Product> products;
}
