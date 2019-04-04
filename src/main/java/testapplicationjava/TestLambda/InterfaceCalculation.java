package testapplicationjava.TestLambda;


@FunctionalInterface
// interfejs funkcjonalny może zawierać tylko jedną metodę abstrakcyjną


// Package  function interface
// https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html



public interface InterfaceCalculation {

    int calculation(int a, int b);




    //modyfikator dostępu "default" pozwala na dostęp do danego elementy tylko klasom z danego pakietu
    default public void off(){
        System.out.println("Wyłączenie...");
    }


}
