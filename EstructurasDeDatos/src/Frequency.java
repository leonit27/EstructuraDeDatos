import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Frequency {
    public static String pedirPalabras(Scanner s) {
        System.out.print("Introduce las palabras separadas por comas: ");
        return s.nextLine();
    }

    public static void rellenarArrayList(ArrayList<String> palabras, String palabrasIntroducidas) {
        //Separamos las palabras introducidas separadas por comas y los metemos en una array
        String[] partes = palabrasIntroducidas.split(",");

        //Recorremos la array "partes" y añadimos todos los elementos a la ArrayList palabras
        for (String parte : partes) {
            palabras.add(parte.trim()); //El metodo trim sirve para eliminar espacios innecesarios entre las comas
        }
    }

    public static void rellenarMapa(ArrayList<String> palabras, Map<String, Integer> repeticiones) {
        for (String palabra : palabras) {
            //Actualizamos el Map con la clave (palabra) e incrementamos su valor asociado por cada vez que se repita la palabra
            repeticiones.put(palabra, repeticiones.getOrDefault(palabra, 0) + 1);
        }
    }

    public static void main(String[] args) {
        //Creamos la ArrayList que contendrá las palabras introducidas
        ArrayList<String> palabras = new ArrayList<>();

        //Creamos el mapa que contendrá cuantas veces se repite una palabra
        Map<String, Integer> repeticiones = new HashMap<>();

        //Creamos el Scanner
        Scanner s = new Scanner(System.in);

        //Pedimos las palabras
        String palabrasIntroducidas = pedirPalabras(s);

        //Cerramos el Scanner
        s.close();

        //Metemos las palabras introducidas en la ArrayList
        rellenarArrayList(palabras, palabrasIntroducidas);

        //Actualizamos el mapa con las terminaciones y el número de veces que se repiten
        rellenarMapa(palabras, repeticiones);

        //Mostramos el mapa
        System.out.println(repeticiones);
    }
}