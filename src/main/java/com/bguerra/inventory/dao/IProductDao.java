package com.bguerra.inventory.dao;

import com.bguerra.inventory.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Long> {
}
