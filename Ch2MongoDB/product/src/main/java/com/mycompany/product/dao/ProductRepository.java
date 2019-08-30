package com.mycompany.product.dao;

import com.mycompany.product.entity.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman.zeylikovich - Project cloud-native-java
 */
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCatId(int catId);
}
