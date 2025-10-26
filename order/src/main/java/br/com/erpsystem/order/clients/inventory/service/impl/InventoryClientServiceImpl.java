package br.com.erpsystem.order.clients.inventory.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.stereotype.Service;

import br.com.erpsystem.order.clients.inventory.service.IInventoryClientService;

@Service
public class InventoryClientServiceImpl implements IInventoryClientService {

    private static final String BASE_URL = "http://localhost:8082/api/v1/inventories";
    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    
    private final HttpClient httpClient;

    public InventoryClientServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    private String buildUrl(String skuCode, Integer quantity) {
        return String.format("%s?skuCode=%s&quantity=%d", BASE_URL, skuCode, quantity);
    }

    private HttpRequest buildRequest(String skuCode, Integer quantity) {
        return HttpRequest.newBuilder()
                .uri(URI.create(buildUrl(skuCode, quantity)))
                .timeout(TIMEOUT)
                .GET()
                .build();
    }

    @Override
    public boolean isInStock(String skuCode, Integer quantity) {
        try {
            HttpRequest request = buildRequest(skuCode, quantity);
            HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
            
            return response.statusCode() == 200;
            
        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            System.err.println("Erro ao verificar estoque para SKU " + skuCode + ": " + e.getMessage());
            return false;
        }
    }
}