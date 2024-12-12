import java.io.*;
import java.util.*;

public class CountCountries {
    public static String pedirPais(Scanner s) {
        System.out.print("De qué país deseas conocer la cantidad de alumnos: ");
        return s.nextLine();
    }

    public static void main(String[] args) throws IOException {
        //Creamos el reader para leer el archivo
        BufferedReader reader = new BufferedReader(new FileReader("Colfuturo-Seleccionados.csv"));

        //Abrimos el Scanner
        Scanner s = new Scanner(System.in);

        //Creamos el mapa que contendrá el número de alumnos en cada país
        Map<String, Integer> map = new HashMap<>();

        //Pedimos el pais del cual queremos conocer los alumnos
        String pais = pedirPais(s);

        String line;

        while ((line = reader.readLine())!=null) {
            //Separamos los campos por comas y los metemos en una array
            String[] data = line.split(",");

            //Cogemos el campo 7 de la línea
            Integer freq = map.get(data[6]);

            if (freq==null) map.put(data[6], 1);
            else map.put(data[6], freq+1);

            //Que se puede resumir utilizando el operador ternario
            map.put(data[6], freq==null ? 1: freq+1);
        }

        //Imprimos el número de alumnos en el país introducido
        System.out.println(map.getOrDefault(pais, 0));

        //Cerramos el reader y el Scanner
        reader.close();
        s.close();
    }
}
