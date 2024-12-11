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

    public static void repartirBilletes(ArrayList<Integer> billetes, int participantes, Map<Integer, ArrayList<Integer>> reparticion) {
        ArrayList<Integer> billetesParticipante; //Creamos la lista que contendrá los billetes de cada uno

        int contador = 0; //Creamos el contador que contendrá la posición actual en la que estamos en la lista de billetes a repartir

        for (int i = 0; i < (billetes.size() + participantes - 1) / participantes; i++) {
            for (int participante = 0; participante < participantes; participante++) {
                billetesParticipante = new ArrayList<>(); //Creamos una nueva lista para que no se solapen los billetes de cada participante
                ArrayList<Integer> billetesObtenidos = reparticion.getOrDefault(participante, new ArrayList<>()); //Obtenemos los billetes que ya ha recibido este participante, si existen

                //Añadimos los billetes ya obtenidos a la nueva lista
                for (Integer billeteObtenido : billetesObtenidos) {
                    billetesParticipante.add(billeteObtenido);
                }

                billetesParticipante.add(billetes.get(contador)); //Añadimos el siguiente billete al participante
                reparticion.put(participante, billetesParticipante); //Actualizamos la repartición con el nuevo billete asignado

                // Si aún quedan billetes, incrementamos el contador, si no, salimos del bucle
                if (contador < billetes.size() - 1) contador++;
                else break;
            }
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

        //Cerramos el Scanner
        s.close();

        //Metemos los billetes introducidos en la ArrayList
        rellenarArrayList(billetes, billetesIntroducidos);

        //Repartimos los billetes a los participantes
        repartirBilletes(billetes, participantes, reparticion);

        //Mostramos el mapa con los billetes repartidos
        System.out.println(reparticion);
    }
}