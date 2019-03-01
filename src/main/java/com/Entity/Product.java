package com.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="ID_product")
    private Long id;

    @Getter
    @Column(name="name_product")
    private String name;

    @Getter
    @Setter
    @Column(name="price_product")
    private int price;

    @Getter
    @Setter
    @Column(name="test_str")
    private String testStr;
}
