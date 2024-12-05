import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaisCapital {
    public static void mostrarCapital(Map<String, String> mapa, Scanner s) {
        //Creamos las variables
        String pais;
        char finalizar;

        do {
            //Pedimos un país europeo al usuario
            System.out.print("Introduce un país europeo: ");
            pais = s.nextLine();

            //Mostramos su capital o, si no existe en el mapa, salta un mensaje
            if (mapa.containsKey(pais)) System.out.printf("La capital de %s es %s %n", pais, mapa.get(pais));
            else System.out.println("El país introducido es incorrecto o no está en la base de datos");

            //Pedimos al usuario si quiere continuar con el programa
            System.out.print("Deseas ver la capital de más paises? (S/N): ");
            finalizar = s.nextLine().charAt(0);
        } while (finalizar != 'N');
    }
    public static void main(String[] args) {
        //Creamos el mapa
        Map<String, String> mapa = new HashMap<>();

        //Abrimos el Scanner
        Scanner s = new Scanner(System.in);

        //Introducimos los paises con sus respectivas capitales en el mapa
        mapa.put("Francia", "París");
        mapa.put("España", "Madrid");
        mapa.put("Italia", "Roma");
        mapa.put("Alemania", "Berlín");
        mapa.put("Inglaterra", "Londres");
        mapa.put("Noruega", "Oslo");

        //Mostramos las capitales de los paises introducidos por el usuario
        mostrarCapital(mapa, s);

        //Cerramos el Scanner
        s.close();
    }
}