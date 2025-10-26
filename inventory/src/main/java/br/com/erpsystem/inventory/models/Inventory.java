package br.com.erpsystem.inventory.models;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import br.com.erpsystem.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory extends BaseEntity {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Override
    public UUID getId() {
        return super.getId();
    }
    
    @Column(name = "created_at", nullable = false, updatable = false)
    @Override
    @CreatedDate
    public OffsetDateTime getCreatedAt() {
        return super.getCreatedAt();
    }
        
    @Column(name = "sku_code", nullable = false)
    private String skuCode;
    
    @Column(name = "quantity", nullable = false)
    
    private Integer quantity;

    

}
