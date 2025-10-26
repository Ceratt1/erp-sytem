package br.com.erpsystem.order.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import br.com.erpsystem.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Override
    @GeneratedValue(strategy= GenerationType.UUID)
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
 
    @Column(name = "price", nullable = false)
    private BigDecimal price;
 
    @Column(name = "quantity", nullable = false)
    @Min(1)
    private Integer quantity;

    @Transient
    private UUID productId;
}