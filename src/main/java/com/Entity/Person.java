package com.Entity;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;


@ToString
@Data
@NoArgsConstructor

@Entity
@Table(name = "PERSON")
 public class Person  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;


    @Getter
    @Column(name="name")
    private  String name;


    public Person(String name)
    {
       this.name = name;
    }







}



