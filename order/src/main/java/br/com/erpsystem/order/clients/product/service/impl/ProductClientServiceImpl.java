package br.com.erpsystem.order.clients.product.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.erpsystem.exceptions.DomainException;
import br.com.erpsystem.order.clients.product.dtos.ProductClientResponse;
import br.com.erpsystem.order.clients.product.service.IProductClientService;
import br.com.erpsystem.order.exceptions.ProductNotFoundException;

@Service
public class ProductClientServiceImpl implements IProductClientService {

    private static final String BASE_URL = "http://localhost:8080/api/v1/products";
    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    
    public ProductClientServiceImpl(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    private String buildUrl(UUID productId) {
        return "%s/%s".formatted(BASE_URL, productId);
    }

    private HttpRequest buildRequest(UUID productId) {
        return HttpRequest.newBuilder()
                .uri(URI.create(buildUrl(productId)))
                .timeout(TIMEOUT)
                .header("Accept", "application/json")
                .GET()
                .build();
    }

    @Override
    public ProductClientResponse findById(UUID productId) {
        try {
            HttpRequest request = buildRequest(productId);
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch (response.statusCode()) {
                case 200 -> {
                    return objectMapper.readValue(response.body(), ProductClientResponse.class);
                }
                case 404 -> {
                    throw new ProductNotFoundException("Product with id " + productId + " not found");
                }
                default -> throw new DomainException("Erro ao buscar produto: HTTP " + response.statusCode());
            }
            
        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            throw new RuntimeException("Erro ao buscar produto " + productId, e);
        }
    }
}