package com.Entity;


import lombok.*;

import javax.persistence.*;


@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PERSON")
 public class Person  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;


    @Column(name="name")
    @Getter
    @Setter
    private  String name;

    @Getter
    @Setter
    private String description;

   @Transient
    private String testStr;



    public Person(String name)
    {
       this.name = name;
    }


   public Person(String name, String description)
   {
      this.name = name;
      this.description = description;
   }




}



