package testapplicationjava.TestLambda;

import com.sun.org.apache.xpath.internal.Arg;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;


/*
Typy generyczne:
E - typ elementu kolekcji
K i V - klucze i wartosići tablic
T - dowolny typ, U i S w razie potrzeby takżę dowolny typ

 */
// przykłady? http://zacznijprogramowac.net/wyrazenia-lambda/
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
