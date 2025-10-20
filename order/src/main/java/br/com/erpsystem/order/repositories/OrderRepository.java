package br.com.erpsystem.order.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erpsystem.order.models.Order;

@Repository
public interface  OrderRepository extends JpaRepository<Order, UUID> {
    
}
