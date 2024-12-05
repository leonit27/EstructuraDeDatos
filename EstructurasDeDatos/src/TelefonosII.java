import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelefonosII {
    public static void mostrarTelefono(Map<String, String> mapa, Scanner s) {
        //Creamos las variables
        String contacto;
        char finalizar;

        do {
            //Pedimos un contacto al usuario
            System.out.print("Introduce el primer nombre de un contacto: ");
            contacto = s.nextLine();

            //Mostramos su número de teléfono o, si no existe en el mapa, salta un mensaje
            if (mapa.containsKey(contacto)) System.out.printf("Los números de teléfono de %s son %s %n", contacto, mapa.get(contacto));
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

        //Introducimos los contactos con sus respectivos números de teléfono en el mapa (cada persona tiene 2 números)
        ArrayList<String> numeros = new ArrayList<>(); //Creamos una ArrayList para guardar los múltiples números de cada persona

        //Añadimos los números a la ArrayList
        numeros.add("600124556");
        numeros.add("611987654");

        //Añadimos el nombre con la lista de números en el mapa
        mapa.put("Juan", String.valueOf(numeros));

        //Creamos una nueva lista para que no se solapen los números
        new ArrayList<>();

        numeros.add("622345678");
        numeros.add("633876543");
        mapa.put("María", String.valueOf(numeros));
        new ArrayList<>();
        numeros.add("622345678");
        numeros.add("633876543");
        mapa.put("Pedro", String.valueOf(numeros));
        numeros = new ArrayList<>();
        numeros.add("666789012");
        numeros.add("677890123");
        mapa.put("Ana", String.valueOf(numeros));
        numeros = new ArrayList<>();
        numeros.add("688901234");
        numeros.add("699012345");
        mapa.put("Luis", String.valueOf(numeros));
        numeros = new ArrayList<>();
        numeros.add("600345678");
        numeros.add("611456789");
        mapa.put("Sofía", String.valueOf(numeros));

        //Mostramos los teléfonos de los contactos introducidos por el usuario
        mostrarTelefono(mapa, s);

        //Cerramos el Scanner
        s.close();
    }
}