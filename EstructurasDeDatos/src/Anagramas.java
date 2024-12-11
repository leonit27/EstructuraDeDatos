import java.io.*;
import java.util.*;

public class Anagramas {
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("spanish-dict.txt"));
        Map<String, ArrayList<String>> anagramas = new HashMap<>();
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
        }
        System.out.println(anagramas);
        reader.close();
    }
}