package com.sit.int202.backend.ProductCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getProductCategoryList() {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll();
        return productCategoryList;
    }

    public ProductCategory getProductCategory(long category_id) {
        ProductCategory productCategory = productCategoryRepository.getOne(category_id);
        return productCategory;
    }

    public ProductCategory create(ProductCategory productCategory) {
        ProductCategory productCategory_return = productCategoryRepository.save(productCategory);
        return productCategory_return;
    }

    public long delete(long productCategory_id) {
        productCategoryRepository.deleteById(productCategory_id);
        return productCategory_id;
    }

    public ProductCategory getProductCategoryByName(String category_name){
        ProductCategory productCategory = productCategoryRepository.findByCategoryName(category_name);
        return productCategory;
    }

}