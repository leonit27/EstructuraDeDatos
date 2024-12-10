import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Botin {
    public static int pedirParticipantes(Scanner s) {
        System.out.print("Introduce el número de participantes a repartir los billetes: ");
        return s.nextInt();
    }

    public static String pedirBilletes(Scanner s) {
        System.out.print("Introduce los billetes a repartir separados por comas: ");
        return s.nextLine();
    }

    public static void rellenarArrayList(ArrayList<Integer> billetes, String billetesIntroducidos) {
        //Separamos los billetes introducidos separados por comas y los metemos en una array
        String[] partes = billetesIntroducidos.split(",");

        //Recorremos la array "partes" y añadimos todos los elementos a la ArrayList billetes
        for (String parte : partes) {
            billetes.add(Integer.valueOf(parte.trim())); //El metodo trim sirve para eliminar espacios innecesarios entre las comas
        }
    }

    public static void main(String[] args) {
        //Creamos la ArrayList que contendrá los billetes introducidos
        ArrayList<Integer> billetes = new ArrayList<>();

        //Creamos el mapa que contendrá la repartición de los billetes
        Map<Integer, ArrayList<Integer>> reparticion = new HashMap<>();

        //Abrimos el Scanner
        Scanner s = new Scanner(System.in);

        //Pedimos los participantes
        int participantes = pedirParticipantes(s);

        //Esto asegura que posteriormente el Scanner no lea una línea vacía
        s.nextLine();

        //Pedimos los billetes
        String billetesIntroducidos = pedirBilletes(s);

        //Metemos los billetes introducidos en la ArrayList
        rellenarArrayList(billetes, billetesIntroducidos);

        ArrayList<Integer> lista;

        int contador = 0;

        for (int i = 0; i < billetes.size(); i++) {
            for (int participante = 0; participante < participantes - 1; participante++) {
                lista = new ArrayList<>();
                lista.add(billetes.get(contador));
                contador++;
                reparticion.put(participante, lista);
            }
        }

        System.out.println(reparticion);
    }
}