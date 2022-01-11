package com.resturent.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Document(collation = "Dishes")
public class Dishes {
    @Id
    private int id;
    private String dishName;
    private String dishDescription;
    private String dishCategory;
    private BigDecimal price;
    private List<String> dishImages;
}
