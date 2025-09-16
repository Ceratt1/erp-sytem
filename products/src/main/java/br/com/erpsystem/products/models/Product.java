package br.com.erpsystem.products.models;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import br.com.erpsystem.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Document(collection = "products")
@Getter
@Setter
@Accessors(chain = true)
public class Product extends BaseEntity {

    @NonNull
    private String name;
    
    private String description;
    
    @NonNull
    private BigDecimal price;

  
}
