import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MejorTerminacion {
    public static String pedirBoletos(Scanner s) {
        System.out.print("Introduce los números de los boletos separados por comas (deben tener 5 cifras): ");
        return s.nextLine();
    }

    public static void rellenarArrayList(ArrayList<String> boletos, String boletosIntroducidos) {
        //Separamos los boletos introducidos por comas y los metemos en una array
        String[] partes = boletosIntroducidos.split(",");

        //Recorremos la array "partes" y añadimos todos los elementos a la ArrayList boletos
        for (String parte : partes) {
            boletos.add(parte.trim()); //El metodo trim sirve para eliminar espacios innecesarios entre las comas
        }
    }

    public static void rellenarMapa(ArrayList<String> boletos, Map<Integer, Integer> terminaciones) {
        int ultimoDigito; //Creamos la variable para almacenar el último dígito

        for (String boleto : boletos) {
            ultimoDigito = Character.getNumericValue(boleto.charAt(4)); //El metodo getNumericValue sirve para convertir un carácter a su valor numérico equivalente
            //Actualizamos el Map con la clave (ultimoDigito) e incrementamos su valor asociado
            terminaciones.put(ultimoDigito, terminaciones.getOrDefault(ultimoDigito, 0) + 1);
        }
    }
    
    public static void main(String[] args) {
        //Creamos la ArrayList que contendrá los boletos introducidos
        ArrayList<String> boletos = new ArrayList<>();

        //Creamos el mapa que contendrá cuantas veces se repite una terminación
        Map<Integer, Integer> terminaciones = new HashMap<>();

        //Creamos el Scanner
        Scanner s = new Scanner(System.in);

        //Pedimos los boletos
        String boletosIntroducidos = pedirBoletos(s);

        //Cerramos el Scanner
        s.close();

        //Metemos los boletos introducidos en la ArrayList
        rellenarArrayList(boletos, boletosIntroducidos);

        //Actualizamos el mapa con las terminaciones y el número de veces que se repiten
        rellenarMapa(boletos, terminaciones);

        //Mostramos el mapa
        System.out.println(terminaciones);
    }
}