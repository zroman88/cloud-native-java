package com.mycompany.product;

import java.util.List;

import com.mycompany.product.dao.ProductRepository;
import com.mycompany.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
