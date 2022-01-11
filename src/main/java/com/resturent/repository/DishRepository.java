package com.resturent.repository;

import com.resturent.model.Dishes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends MongoRepository<Dishes, Integer> {

    List<Dishes> findByDishName(String name);
}
