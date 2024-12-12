import java.io.*;
import java.util.*;

public class Anagramas {
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static int pedirMinGroupSize(Scanner s) {
        System.out.print("Introduce el mínimo número de valores para que salgan impresos: ");
        return s.nextInt();
    }

    public static void main(String[] args) throws IOException {
        //Creamos el reader para leer el archivo
        BufferedReader reader = new BufferedReader(new FileReader("spanish-dict.txt"));

        //Creamos el mapa que contendrá los anagramas de cada palabra
        Map<String, ArrayList<String>> anagramas = new HashMap<>();

        //Abrimos el Scanner
        Scanner s = new Scanner(System.in);

        //Pedimos el mínimo número de valores para imprimir
        int minGroupSize = pedirMinGroupSize(s);

        ArrayList<String> palabrasAnagrama;
        String line;
        while ((line = reader.readLine())!=null) {
            palabrasAnagrama = new ArrayList<>();
            ArrayList<String> palabrasObtenidas = anagramas.getOrDefault(alphabetize(line), new ArrayList<>());

            for (String palabraObtenida : palabrasObtenidas) {
                palabrasAnagrama.add(palabraObtenida);
            }

            palabrasAnagrama.add(alphabetize(line));

            anagramas.put(alphabetize(line), palabrasAnagrama);

            if (anagramas.get(alphabetize(line)).size() > minGroupSize) {
                System.out.println(alphabetize(line) + " --> " + anagramas.get(alphabetize(line)) + " --> " + anagramas.get(alphabetize(line)).size());
            }
        }

        //Cerramos el reader y el Scanner
        reader.close();
        s.close();
    }
}