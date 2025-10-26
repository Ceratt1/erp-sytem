package br.com.erpsystem.inventory.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erpsystem.inventory.models.Inventory;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, UUID> {

    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity);

}