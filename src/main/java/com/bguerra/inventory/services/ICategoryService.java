package com.bguerra.inventory.services;

import com.bguerra.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    public ResponseEntity<CategoryResponseRest> search();

    public ResponseEntity<CategoryResponseRest> searchById(Long id);
}
