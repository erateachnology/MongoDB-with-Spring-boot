package com.resturent.controller;
import com.resturent.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private DishService dishService;

    @PostMapping("/add/dishes")
    public ResponseEntity<?> addDishes(
            @RequestParam("dishName") String dishName,
            @RequestParam("dishDescription") String dishDescription,
            @RequestParam("dishCategory") String dishCategory,
            @RequestParam("price") BigDecimal price,
            @RequestParam(value = "dishImages", required = false) MultipartFile dishImages
    ){
      try{
          return ResponseEntity.ok(dishService.addDishes(dishName,dishDescription,dishCategory,price,dishImages));
      }catch (HttpClientErrorException.BadRequest | HttpServerErrorException exception){
          return ResponseEntity.status(exception.getRawStatusCode()).headers(exception.getResponseHeaders())
                  .body(exception.getResponseBodyAsString());
      }
    }
}
