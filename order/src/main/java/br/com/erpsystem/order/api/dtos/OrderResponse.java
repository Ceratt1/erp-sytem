package br.com.erpsystem.order.api.dtos;

import java.math.BigDecimal;

import br.com.erpsystem.dtos.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse extends BaseEntityDto{
       
    private String skuCode;
 
    private BigDecimal price;
 
    private Integer quantity;

}
