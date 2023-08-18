package Recursividad;
import java.util.Scanner;
public class Ejercicio2SumatoriaRecursiva {
    public static Scanner input = new Scanner(System.in);
    public static int sumatoria(int numLimite, int resultado){ //Función recursiva sumatoria
        if(numLimite==0){ //Si el numero es 0, entonces mostramos directamente el resultado
            return resultado;
        }else{ //Sino, llamamos nuevamente a la función, pero restando en 1 el numero limite y sumando al resultado el valor actual de este
            return sumatoria(numLimite-1, resultado + numLimite);
        }
    }
    public static void main(String[] args) {
        int numeroLimite; //Definimos numeroLimite y asignamos su valor por teclado
        System.out.println("Ingrese el numero limte para la sumatoria: ");
        numeroLimite = input.nextInt();
        //Mostramos el resultado llamando a la función recursiva
        System.out.println("La sumatoria de los numeros del 1 al " + numeroLimite + " es : " + sumatoria(numeroLimite, 0));
    }
}
