package com.mycompany.product.dao;

import com.mycompany.product.entity.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman.zeylikovich - Project cloud-native-java
 */
@Cacheable("productsByCategoryCache")
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCatId(int catId);
}
