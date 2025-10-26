package br.com.erpsystem.dtos;

import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseEntityDto {

    private UUID id;
    private OffsetDateTime createdAt;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
