package com.bguerra.inventory.controller;

import com.bguerra.inventory.model.Category;
import com.bguerra.inventory.response.CategoryResponseRest;
import com.bguerra.inventory.services.ICategoryService;
import com.bguerra.inventory.util.CategoryExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
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

    @PostMapping("/categories")//save categories
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) {
        ResponseEntity<CategoryResponseRest> response = service.save(category);
        return response;
    }

    @PutMapping("/categories/{id}")// update categories
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.update(category, id);
        return response;
    }

    @DeleteMapping("/categories/{id}")// delete categories
    public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.deleteById(id);
        return response;
    }

    @GetMapping("/categories/export/excel")//export to excel file
    public void exportToExcel(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
        String headerKey = "Conteent-Disposition";
        String headerValue = "attachment; filename=result_category";
        response.setHeader(headerKey,headerValue);

        ResponseEntity<CategoryResponseRest> responseEntity = service.search();
        CategoryExcelExporter excelExporter = new CategoryExcelExporter(responseEntity.getBody().getCategoryResponse().getCategory());
        excelExporter.export(response);
    }

}
