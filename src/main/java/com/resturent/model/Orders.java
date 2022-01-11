package com.resturent.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "Orders")
@Getter
@Setter
@ToString
public class Orders {
    @Id
    private int id;
    private String orderName;
    private List<Dishes> dishes;
    private String deliveryAddress;
}
