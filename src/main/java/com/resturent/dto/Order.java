package com.resturent.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.resturent.model.Dishes;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private String orderName;
    private List<Dishes> dishes;
    private String deliveryAddress;
}
