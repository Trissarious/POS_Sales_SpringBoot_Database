package com.pos_sales.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos_sales.model.ProductModel;
import com.pos_sales.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository prepo;

    // C - Create or insert a product record
    public ProductModel insertProduct(ProductModel product) {
        // Ensure the isDeleted flag is set to false when inserting a new product
        product.setDeleted(false);
        return prepo.save(product);
    }

    // Read all records (including non-deleted products)
    public List<ProductModel> getAllProduct() {
        return prepo.findAllByIsDeletedFalse();
    }

    // R - Read or search product record by product name
    public ProductModel findByProductName(String productname) {
        return prepo.findByProductnameAndIsDeletedFalse(productname);
    }

    // U - Update a product record
    public ProductModel putProduct(int productid, ProductModel newProductDetails) throws Exception {
        try {
            // Step 1 - search the id number of the product
            ProductModel product = prepo.findById(productid).orElseThrow(() -> new NoSuchElementException("Product " + productid + " does not exist!"));

            // Step 2 - update the record
            product.setProductname(newProductDetails.getProductname());
            product.setPrice(newProductDetails.getPrice());

            // Ensure the isDeleted flag remains false after updates
            product.setDeleted(false);

            // Step 3 - save the information and return the value
            return prepo.save(product);
        } catch (NoSuchElementException nex) {
            throw new Exception("Product " + productid + " does not exist!");
        }
    }

    public ProductModel putQuantity(int productid, ProductModel newProductDetails) throws Exception {
        try {
            // Step 1 - search the id number of the product
            ProductModel product = prepo.findById(productid).orElseThrow(() -> new NoSuchElementException("Product " + productid + " does not exist!"));

            // Step 2 - update the record
            product.setQuantity(newProductDetails.getQuantity());

            // Ensure the isDeleted flag remains false after updates
            product.setDeleted(false);

            // Step 3 - save the information and return the value
            return prepo.save(product);
        } catch (NoSuchElementException nex) {
            throw new Exception("Product " + productid + " does not exist!");
        }
    }

    // D - Delete product record (soft delete)
    public String deleteProduct(int productid) {
        String msg;
        ProductModel product = prepo.findById(productid).orElse(null); // Find the record

        if (product != null) {
            // Soft delete: set the isDeleted flag to true
            product.setDeleted(true);
            prepo.save(product);

            msg = "Product " + productid + " successfully soft deleted!";
        } else {
            msg = "Product " + productid + " is NOT found!";
        }

        return msg;
    }
}
