package br.com.erpsystem.order.clients.inventory.service;

public interface IInventoryClientService {

    boolean isInStock(String skuCode, Integer quantity);
}
