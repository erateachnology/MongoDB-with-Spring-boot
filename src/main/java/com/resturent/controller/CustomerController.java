package com.resturent.controller;

import com.resturent.dto.Order;
import com.resturent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place/order")
    public ResponseEntity<?> placeOrder(@RequestBody Order order){
       try{
           return ResponseEntity.ok(orderService.placeOrder(order));
       }catch (HttpClientErrorException | HttpServerErrorException exception){
           return ResponseEntity.status(exception.getRawStatusCode()).headers(exception.getResponseHeaders())
                   .body(exception.getResponseBodyAsString());
       }
    }

    @GetMapping("find/dish/{name}")
    public ResponseEntity<?> findDishById(@PathVariable String name){
        try{
            return ResponseEntity.ok(orderService.findDishByName(name));
        }catch (HttpClientErrorException | HttpServerErrorException exception){
            return ResponseEntity.status(exception.getRawStatusCode()).headers(exception.getResponseHeaders())
                    .body(exception.getResponseBodyAsString());
        }
    }
}
