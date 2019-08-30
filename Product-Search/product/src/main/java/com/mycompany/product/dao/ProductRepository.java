package com.mycompany.product.dao;

import com.mycompany.product.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author roman.zeylikovich - Project cloud-native-java
 */
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByCatId(int catId);
}
