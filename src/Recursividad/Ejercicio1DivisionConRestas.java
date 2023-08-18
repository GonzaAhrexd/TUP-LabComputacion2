package Recursividad;
import java.util.Scanner;
public class Ejercicio1DivisionConRestas {
    public static Scanner input = new Scanner(System.in); //Declaramos el input de tipo Scanner con alcance global para evitarnos problemas*/

    public static int divisonConRestas(int numerador , int denominador){ //Función de división con restas de forma iterativa
        int resultado = 0; //Inicializamos en 0
        while(!(numerador <= 0)){ //Entramos a un while mientras el numerador no sea mayor o igual a 0
            numerador -= denominador; //Restamos del numerador el denominador
            resultado++; //Incrementamos la variable resultado en 1
        }
        if(numerador==0) { //Si nuestro resultado al final es 0, que retorne la variable resultado como esta
            return resultado;
        }
        else{ //Sino, que le reste 1, ya que estaría quedando con decimales el resultado
            return resultado-1;
        }
    }
    public static int divisonConRestas(int numerador, int denominador, int contador){
        if(numerador<=0){ //Caso base, si el numerador es menor o igual a 0
            if(numerador==0){ //Si es 0, devolver el contador directamente
                return contador;
            }else{ //Si es menor a 0, devolver el contador menos 1, ya que se trataría de un número con decimales
                return contador -1;
            }

        }else { //Sino se cumple lo anterior, se llamará a la función recursivamente, cambiando el numerador por la resta entre este y el denominador, y el contador irá incrementando en 1
            return divisonConRestas(numerador - denominador, denominador, contador + 1);
        }
    }
    public static void main(String[] args) {
        int numerador, denominador; //Definimos numerador y denominador y le asignamos valores por medio del teclado
        System.out.println("Ingrese el numerador: ");
        numerador = input.nextInt();
        System.out.println("Ingrese el denominador: ");
        denominador = input.nextInt();
        input.nextLine(); //Utilizamos este nextLine para evitar errores consumiendo el valor de escape anterior
        System.out.println("Quieres hacerlo de forma recursiva? (si/no)"); //Preguntamos si se quiere realizar la operación de forma recursiva
        String s = input.nextLine();
        if(s.equalsIgnoreCase("si")){ //Si la respuesta es si, llamamos a la función incluyendo además el 0 como contador inicial
            System.out.println("El resultado es:" + divisonConRestas(numerador,denominador,0));
        }else{ //Si es no, llamamos a la función sin el contador inicial para hacerlo de forma iterativa
            System.out.println(divisonConRestas(numerador,denominador));
        }
    }
}
