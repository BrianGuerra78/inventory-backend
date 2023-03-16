package com.bguerra.inventory.dao;

import com.bguerra.inventory.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {


}
