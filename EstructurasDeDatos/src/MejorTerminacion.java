import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MejorTerminacion {
    public static void rellenarArrayList(ArrayList<String> boletos, String boletosIntroducidos) {
        //Separamos los boletos introducidos por comas y los metemos en una array
        String[] partes = boletosIntroducidos.split(",");

        //Recorremos la array "partes" y añadimos, convirtiendo en números, todos los elementos a la ArrayList boletos
        for (String parte : partes) {
            boletos.add(parte.trim()); //El metodo trim sirve para eliminar espacios innecesarios entre las comas
        }
    }
    
    public static void main(String[] args) {
        ArrayList<String> boletos = new ArrayList<>();

        Map<Integer, Integer> terminaciones = new HashMap<>();

        Scanner s = new Scanner(System.in);

        System.out.print("Introduce los números de los boletos separados por comas (deben tener 5 cifras): ");
        String boletosIntroducidos = s.nextLine();

        rellenarArrayList(boletos, boletosIntroducidos);

        System.out.println(boletos);

        int ultimoDigito;

        for (String boleto : boletos) {
            ultimoDigito = Character.getNumericValue(boleto.charAt(4));
            terminaciones.put(ultimoDigito, terminaciones.getOrDefault(ultimoDigito, 0) + 1);
        }
        System.out.println(terminaciones);
    }
}