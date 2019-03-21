package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class WebController {


    @GetMapping ("/test")
    String funkcja()
    {
        // nie wyświetli stringu, a wyświetli error status=500
        return "test1234ra";
    }



    Set<String> fruit= new HashSet<>();
    String someText="Witaj świecie w Spring Boot i Thymeleaf";

    String testString= "test";
    String pustyString = "";

    @GetMapping("/thymeleaf")
    public ModelAndView getMain() {
        ModelAndView m = new ModelAndView();

        m.setViewName("index");
        m.addObject("pustyString", pustyString);
        m.addObject("testString", testString);
        m.addObject("someText", someText);

        initFruit();
        m.addObject("fruits", fruit);
        return m;
    }




    public void initFruit() {
        for(int i=0;i<=10;i++) {
            fruit.add("owoc"+i);
        }
    }


    // THYMELEAF views https://www.logicbig.com/tutorials/spring-framework/spring-data/sorting-and-pagination.html

}
