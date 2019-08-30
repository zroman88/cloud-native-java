package com.mycompany.product;

import java.util.List;

import com.mycompany.product.dao.ProductRepository;
import com.mycompany.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductService {

    @Autowired
    ProductRepository prodRepo;

    @RequestMapping("/${env}/product/{id}")
    Product getProduct(@PathVariable("id") String id) {
        return prodRepo.findOne(id);
    }

    @RequestMapping("/${env}/products")
    List<Product> getProductIds(@RequestParam("id") int id) {
        return prodRepo.findByCatId(id);
    }

    @PutMapping("/${env}/product/{id}")
    public void insertUpdateProduct(@RequestBody Product product) {
        prodRepo.save(product);
    }

    @DeleteMapping("/${env}/product/{id}")
    public void deleteProduct(@RequestBody Product product) {
        prodRepo.delete(product);
    }
}
