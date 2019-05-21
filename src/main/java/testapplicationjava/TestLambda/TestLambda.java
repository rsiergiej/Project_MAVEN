package testapplicationjava.TestLambda;

import com.sun.org.apache.xpath.internal.Arg;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;


/*
Typy generyczne:
E - typ elementu kolekcji
K i V - klucze i wartosići tablic
T - dowolny typ, U i S w razie potrzeby takżę dowolny typ

 */
// przykłady? http://zacznijprogramowac.net/wyrazenia-lambda/
//https://www.samouczekprogramisty.pl/wyrazenia-lambda-w-jezyku-java/
public class TestLambda {

    private static final Map<String, InterfaceCalculation> calcMap = new HashMap<>();


    public static void main(String[] arg)
    {
        System.out.println("start application Test Lambda");




        calcMap.put("+",(a,b) -> a+b);
        calcMap.put("-", (a,b) -> a-b);
        calcMap.put("/", (a,b) -> a/b);

        InterfaceCalculation multiply = (a,b) -> a*b;
        calcMap.put("*", multiply);

        int a =5;
        int b =13;

        result("+", a, b);
        result("-", a, b);
        result("/", a, b);
        result("*", a, b);


        ArrayList<String> aa = new ArrayList<String>();
        List<Integer> bb = Arrays.asList(1,2,3,4);
        aa.add("test1");
        aa.add("test12");
        aa.add("test13");
        aa.add("test14");
        aa.add("test15");
        aa.add("test16");
        aa.add("test17");
        aa.add("test18");
        Consumer<String> cc = st -> System.out.println(st);
        Consumer<Integer> dd = st -> System.out.println(st);
        aa.forEach(cc);
        bb.forEach(dd);

        System.out.println("NEXT TEST");
        aa.forEach((c) -> System.out.println("Item " + c));

        System.out.println("NEXT TEST");
        aa.forEach((d) ->{
            System.out.println("Iteam" + d);
            if("test13".equals(d))
            {
                System.out.println("HERE");
            }
        });

        System.out.println("NEXT TEST");
        // method reference
        aa.forEach(System.out::println);

        System.out.println("NEXT TEST");
        aa.stream().filter(s->s.contains("test12")).forEach(System.out::println);










//        InterfaceCalculation add = (a,b) ->{
//            if(a<0)
//            {
//                a=3;
//            }
//            return a+b;
//        };
//        int result = add.calculation(-1,3);
//        System.out.println("Wynik to: " + result);



//        InterfaceCalculation interfaceCalculation = new InterfaceCalculation() {
//            @Override
//            public int calculation(int a, int b) {
//                return a+b;
//            }
//        };

//        InterfaceCalculation add = (a,b) -> a+ b;
//        System.out.println(add.calculation(1,2));
//        add.off();







    }




    private static void result(String operatora, int a, int b)
    {
        int result = calcMap.get(operatora).calculation(a,b);
        System.out.println(result);
    }





}
