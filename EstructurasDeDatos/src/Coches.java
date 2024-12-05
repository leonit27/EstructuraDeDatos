import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Coches {
    public static void pedirMarcas(ArrayList<String> coches, Scanner s) {
        //Creamos la variable
        String opcion;

        //Pedimos las marcas de los coches y las añadimos al ArrayList
        do {
            System.out.print("Introduce una marca de coche (para finalizar pulsa enter): ");
            opcion = s.nextLine();
            coches.add(opcion);
        } while (!opcion.isEmpty());
    }

    public static void mostrarMarcas(ArrayList<String> coches) {
        //Imprimimos los coches en lineas diferentes de manera ordenada
        System.out.println("\nLas marcas de coche introducidas, de manera ordenada son:");
        for (String coche : coches) {
            System.out.println(coche);
        }
    }

    public static void main(String[] args) {
        //Creamos una array list
        ArrayList<String> coches = new ArrayList<>();

        //Creamos el Scanner
        Scanner s = new Scanner(System.in);

        //Pedimos las marcas de los coches
        pedirMarcas(coches, s);

        //Cerramos el Scanner
        s.close();

        //Ordenamos la lista
        Collections.sort(coches);

        //Mostramos las marcas en orden
        mostrarMarcas(coches);
    }
}