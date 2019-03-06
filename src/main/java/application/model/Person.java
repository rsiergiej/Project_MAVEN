package application.model;

import lombok.*;

import javax.persistence.*;


@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PERSON")
//@IdClass(Person.class)
@Getter
@Setter
 public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name="id")
    private Long id;



    @Getter
    @Setter
    @Column(name="name")
    private  String name;

    @Getter
    @Setter
    @Column(name="description")
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



