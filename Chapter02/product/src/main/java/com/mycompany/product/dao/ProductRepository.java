package com.mycompany.product.dao;

import com.mycompany.product.entity.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman.zeylikovich - Project cloud-native-java
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Cacheable("productsByCategoryCache")
    List<Product> findByCatId(int catId);

    @CacheEvict(cacheNames = "productsByCategoryCache", key = "#result?.catId")
    Product save(Product product);

    @CacheEvict(cacheNames = "productsByCategoryCache", key = "#p0.catId")
    void delete(Product product);
}
