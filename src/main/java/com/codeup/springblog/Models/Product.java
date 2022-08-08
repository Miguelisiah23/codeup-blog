package com.codeup.springblog.Models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false,length = 50)
    private String price;
}
