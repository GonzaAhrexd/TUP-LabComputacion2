package Recursividad;
import java.util.Scanner;
public class Ejercicio3FactorialConSobrecarga {
    public static Scanner input = new Scanner(System.in);
    public static int factorial(int num){ //Factorial de forma recursiva
        if(num == 1){ //Si el numero es 1, entonces devolvemos 1
            return 1;
        }else{ //Sino, devolvemos la multiplicación de num por el factorial del número anterior de forma recursiva
            return num * factorial(num-1);
        }
    }
    public static int factorial(int num, int res){ //La misma función pero de forma iterativa
        for (int i=1;i<=num;i++){  //Utilizamos un bucle for, que multiplique el res por el iterador hasta llegar al numero limite
            res *= i;
        }
        return res; //Mostramos el res
    }
    public static void main(String[] args) {
        int num; //Definimos num e ingresamos sus valores por teclado
        System.out.println("Ingrese el numero para sacar su factorial: ");
        num = input.nextInt();
        input.nextLine(); //Utilizamos este nextLine para evitar errores consumiendo el valor de escape anterior
        System.out.println("Quieres hacerlo de forma recursiva? (si/no)"); //Preguntamos si se quiere realizar la operación de forma recursiva
        String s = input.nextLine();
        if(s.equalsIgnoreCase("si")){ //Si la respuesta es si llamamos a la función recursiva
            System.out.println("El factorial de " + num + " es: " + factorial(num));
        }else{ //Si es no, llamamos a la función iterativa agregando el 1 para la iteración
            System.out.println("El factorial de " + num + " es: " + factorial(num,1));
        }

    }
}
