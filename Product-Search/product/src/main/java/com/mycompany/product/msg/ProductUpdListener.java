package com.mycompany.product.msg;

import com.mycompany.product.ProductService;
import com.mycompany.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

/**
 * @author roman.zeylikovich - Project cloud-native-java
 */
@Component
public class ProductUpdListener {

    @Autowired
    ProductService productService;

    @JmsListener(destination = "${jms.ProductTopic}", subscription = "productSearchListener")
    public void receiveMessage(ProductUpdMsg msg) {
        Product product = msg.getProduct();
        boolean isDelete = msg.isDelete();
        if (isDelete) {
            productService.deleteProduct(product);
            System.out.println("deleted " + product.getId());
        } else {
            productService.insertUpdateProduct(product);
            System.out.println("upserted " + product.getId());
        }
    }

    // Serialize msg content to json using TextMessage
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.BYTES);
        converter.setTypeIdPropertyName("_type");

        return converter;
    }
}
