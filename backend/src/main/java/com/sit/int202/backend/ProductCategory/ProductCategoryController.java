package com.sit.int202.backend.ProductCategory;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<ProductCategory>> getProductCategoryList() {
        List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList();
        return new ResponseEntity<>(productCategoryList, HttpStatus.OK);
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<ProductCategory> getProductCategory(@PathVariable("product_id") long category_id){
        ProductCategory productCategory = productCategoryService.getProductCategory(category_id);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<ProductCategory> createProductCategory(@Valid @RequestBody ProductCategory productCategory){
        ProductCategory productCategory_return = productCategoryService.create(productCategory);
        return new ResponseEntity<>(productCategory_return, HttpStatus.CREATED);
    }

    @PutMapping("/category/{category_id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@Valid @PathVariable String category_id, @RequestBody ProductCategory productCategory) {
        ProductCategory productCategory_return = productCategoryService.create(productCategory);
        return new ResponseEntity<>(productCategory_return, HttpStatus.OK);
    }
}