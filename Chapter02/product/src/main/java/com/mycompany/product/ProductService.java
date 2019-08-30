package com.mycompany.product;

import java.util.Arrays;
import java.util.List;

import com.mycompany.exceptions.BadRequestException;
import com.mycompany.product.dao.ProductRepository;
import com.mycompany.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductService {

    @Autowired
    ProductRepository prodRepo;

    @GetMapping("/${env}/product/{id}")
    Product getProduct(@PathVariable("id") int id) {
        return prodRepo.findOne(id);
    }

    @GetMapping("/${env}/products")
    List<Product> getProductIds(@RequestParam("id") int id) {
        return prodRepo.findByCatId(id);
    }

    @PostMapping("/${env}/product")
    ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        Product savedProduct = prodRepo.save(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
    }

    @PutMapping("/${env}/product/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        // First fetch an existing product then modify it
        Product existingProduct = prodRepo.findOne(id);

        // Now update it back
        existingProduct.setCatId(product.getCatId());
        existingProduct.setName(product.getName());
        Product savedProduct = prodRepo.save(existingProduct);

        // Return the updated product
        return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/${env}/product/{id}")
    Product deleteProduct(@PathVariable("id") int id) {
        // First fetch an existing product and then delete it.
        Product existingProduct = prodRepo.findOne(id);
        if (existingProduct == null) {
            String errMsg = "Product Not found with code " + id ;
            throw new BadRequestException(BadRequestException.ID_NOT_FOUND, errMsg);
        }

        prodRepo.delete(existingProduct);
        return existingProduct;
    }


}
