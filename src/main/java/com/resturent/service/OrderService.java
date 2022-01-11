package com.resturent.service;

import com.resturent.dto.Order;
import com.resturent.model.Dishes;
import com.resturent.model.Orders;
import com.resturent.repository.DishRepository;
import com.resturent.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DishRepository dishRepository;

    public Orders placeOrder(Order order){
        Orders orders = new Orders();
        orders.setOrderName(order.getOrderName());
        orders.setDishes(order.getDishes());
        orders.setDeliveryAddress(order.getDeliveryAddress());
        return orderRepository.save(orders);
    }

    public List<Dishes> findDishByName(String name){
        return dishRepository.findByDishName(name);
    }
}
