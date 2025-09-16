package br.com.erpsystem.models;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

public abstract class BaseEntity {
    
    @Id
    private UUID id;
        
    @CreatedDate
    private OffsetDateTime createdAt;
    
    protected BaseEntity() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}