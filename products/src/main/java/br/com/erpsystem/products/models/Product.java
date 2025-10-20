package br.com.erpsystem.products.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    @Id
    @Override
    public UUID getId() {
        return super.getId();
    }

    @Field("created_at")
    @Override
    @CreatedDate
    public OffsetDateTime getCreatedAt() {
        return super.getCreatedAt();    
    }
    

    @NonNull
    private String name;
    
    private String description;
    
    @NonNull
    private BigDecimal price;
}