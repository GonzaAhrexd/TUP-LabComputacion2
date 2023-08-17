import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void ingresarArreglo(int[] arreglo){ //Procedimiento para ingresar nuestro arreglo
           for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese un numero: ");
            arreglo[i] = input.nextInt();
        }

    }
    public static void mostrarArreglo(int[] arreglo){ //Procedimiento para mostrar nuestro arreglo
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }

    public static void ordenarMayorMenor(int[] arreglo){ //Procedimiento para ordenar de mayor a menor el arreglo útilizando el método de burbuja
         for (int i = 0; i < arreglo.length -1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if(arreglo[i]<arreglo[j]){
                    int aux = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = aux;
                }
            }            
        }
    }
    public static void main(String[] args) {
        int[] Numeros = new int[3];
        //Ingresamos los números
        ingresarArreglo(Numeros);
        //Los ordenamos
        ordenarMayorMenor(Numeros);
        //Los mostramos
        System.out.println("Numeros ordenados: ");
        mostrarArreglo(Numeros);
       
    }

}
