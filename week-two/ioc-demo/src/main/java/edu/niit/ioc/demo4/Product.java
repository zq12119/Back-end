package edu.niit.ioc.demo4;

import lombok.Data;

@Data
public class Product {
    private String name;
    private double price;
    private Category category;
}