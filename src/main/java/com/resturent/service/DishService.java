package com.resturent.service;

import com.resturent.model.Dishes;
import com.resturent.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;


    public Dishes addDishes(String dishName,
                            String dishDescription,
                            String dishCategory,
                            BigDecimal price, MultipartFile dishImages){
        Dishes dishes = new Dishes();
        dishes.setDishDescription(dishName);
        dishes.setDishDescription(dishDescription);
        dishes.setDishCategory(dishCategory);
        dishes.setPrice(price);
        List<String> dishImageNames = new ArrayList<>();
        dishImageNames.add(dishImages.getOriginalFilename());
        dishes.setDishImages(dishImageNames);
        return dishRepository.save(
               dishes);
    }

}
