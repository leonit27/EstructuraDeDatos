import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Telefonos {
    public static void mostrarTelefono(Map<String, String> mapa, Scanner s) {
        //Creamos las variables
        String contacto;
        char finalizar;

        do {
            //Pedimos un contacto al usuario
            System.out.print("Introduce el primer nombre de un contacto: ");
            contacto = s.nextLine();

            //Mostramos su número de teléfono o, si no existe en el mapa, salta un mensaje
            if (mapa.containsKey(contacto)) System.out.printf("El número de teléfono de %s es %s %n", contacto, mapa.get(contacto));
            else System.out.println("El contacto introducido es incorrecto o no está en la base de datos");

            //Pedimos al usuario si quiere continuar con el programa
            System.out.print("Deseas ver el número de teléfono de más contactos? (S/N): ");
            finalizar = s.nextLine().charAt(0);
        } while (finalizar != 'N');
    }
    public static void main(String[] args) {
        //Creamos el mapa
        Map<String, String> mapa = new HashMap<>();

        //Abrimos el Scanner
        Scanner s = new Scanner(System.in);

        //Introducimos los contactos con sus respectivos números de teléfono en el mapa
        mapa.put("Juan", "600123456");
        mapa.put("María", "611234567");
        mapa.put("Pedro", "622345678");
        mapa.put("Ana", "633456789");
        mapa.put("Luis", "644567890");
        mapa.put("Sofía", "655678901");

        //Mostramos los teléfonos de los contactos introducidos por el usuario
        mostrarTelefono(mapa, s);

        //Cerramos el Scanner
        s.close();
    }
}