package br.com.erpsystem.config.globalexception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    
    private Map<String, Object> createBody(Exception ex, WebRequest request, HttpStatus status) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return body;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(
            Exception ex, WebRequest request) {
        
        HttpStatus status = resolveStatus(ex);
        
        Map<String, Object> body = createBody(ex, request, status);
            
        return new ResponseEntity<>(body, status);
    }
    
    private HttpStatus resolveStatus(Exception ex) {
        ResponseStatus responseStatus = ex.getClass().getAnnotation(ResponseStatus.class);
        
        if (responseStatus != null) {
            return responseStatus.value();
        }
        
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}