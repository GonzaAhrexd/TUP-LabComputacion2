package Parcial1.PracticaParcial;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Practica1 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Integer> miLista = new ArrayList<Integer>();

        miLista.add(7);
        miLista.add(5);
        miLista.add(3);
        miLista.add(9);
        miLista.add(11);

        int n, pos, indice;

        try{
            //Agregar
            System.out.println("Ingrese un numero para ser agregado: ");
            n = input.nextInt();
            miLista.add(n);
            //Mostrar
            System.out.println("Ingrese la posicion que quieres mostrar: ");
            pos  = input.nextInt();
            System.out.println("El  elemento de la posicion ingresada es: " + miLista.get(pos));
            //Eliminar
            System.out.println("Ingrese la posicion que desea eliminar: ");
            indice = input.nextInt();
            miLista.remove(indice);
            System.out.println("Elemento eliminado");
        }catch (InputMismatchException e){
            System.out.println("Se ha ingresado un valor no númerico, intenta nuevamente");
            input.next();
        } catch (IndexOutOfBoundsException e){
            System.out.println("No existe la posición específicada");
        }

        System.out.println("Los valores de la lista son: ");
        for (Integer num :  miLista) {
            System.out.print(num.toString() + ' ');

        }

    }
}
