import java.util.ArrayList;
import java.util.Scanner;

public class Regalos {
    public static int pedirAterrizaje(Scanner s) {
        System.out.print("Introduce el número de portal donde aterriza: ");
        return s.nextInt();
    }

    public static String pedirPortales(Scanner s) {
        System.out.print("Introduce los portales donde debe entregar los regalos separados por comas: ");
        return s.nextLine();
    }

    public static void rellenarArrayList(ArrayList<Integer> portales, String portalesIntroducidos) {
        //Separamos los portales introducidos por comas y los metemos en una array
        String[] partes = portalesIntroducidos.split(",");

        //Recorremos la array "partes" y añadimos, convirtiendo en números, todos los elementos a la ArrayList portales
        for (String parte : partes) {
            portales.add(Integer.parseInt(parte.trim())); //El metodo trim sirve para eliminar espacios innecesarios entre las comas
        }
    }

    public static void ordenPortales(ArrayList<Integer> portales, int distancia, int portal, int index, int posicionActual) {
        System.out.print("El orden al que irá a los portales es: ");

        while (!portales.isEmpty()) {
            for (int i = 0; i < portales.size(); i++) {
                //Asignamos la diferencia (distancia actual) como la resta de la posición actual con el siguiente portal
                int diferencia = Math.abs(posicionActual - portales.get(i));

                //Si la diferencia (distancia actual) es igual a la anterior...
                if (distancia == diferencia) {
                    portal = Math.max(portal, portales.get(i));
                    index = portales.indexOf(portal);
                }

                //Si la diferencia (distancia actual) es menor...
                if (distancia > diferencia) {
                    //Modificamos la variable distancia y le asignamos el valor más pequeño (diferencia)
                    distancia = diferencia;
                    //El portal al que irá por ahora es el actual (i)
                    portal = portales.get(i);
                    //El index es la posición de la lista del portal actual
                    index = portales.indexOf(portal);
                }
            }
            //Le cambiamos la posición al portal al que va
            posicionActual = portal;

            //Imprimimos el portal, si es el último se imprime sin coma
            if (portales.size() > 1) System.out.print(portal + ", ");
            else System.out.print(portal);

            //Si la longitud de la lista de portales sigue siendo mayor a 1
            if (portales.size() > 1) {
                //Eliminamos el portal al que ya ha ido de la array
                portales.remove(index);
                //Le asignamos a distancia otro valor predeterminado (resta de la posicion actual meonos el primer portal de la array)
                distancia = Math.abs(posicionActual - portales.get(0));
                //Le asignamos a portal al primer portal de la array nuevamente
                portal = portales.get(0);
            } else break; //Si no, ya hemos ido a todos los portales, acabamos el bucle
        }
    }

    public static void main(String[] args) {
        //Creamos el ArrayList y la variable
        ArrayList<Integer> portales = new ArrayList<>();

        //Abrimos el Scanner
        Scanner s = new Scanner(System.in);

        //Pedimos al usuario el portal donde aterriza y lo guardamos en la variable aterrizaje
        int aterrizaje = pedirAterrizaje(s);

        //Esto asegura que posteriormente el Scanner no lea una línea vacía
        s.nextLine();

        //Pedimos al usuario los portales donde debe entregar los regalos y lo guradamos en la variable portalesIntroducidos
        String portalesIntroducidos = pedirPortales(s);

        //Cerramos el Scanner
        s.close();

        //Metemos los portales introducidos por el usuario en la ArrayList
        rellenarArrayList(portales, portalesIntroducidos);

        //Asignamos la distancia a la resta del aterrizaje menos el primer portal del array
        int distancia = Math.abs(aterrizaje - portales.get(0));

        //Asignamos portal al primer portal de la array
        int portal = portales.get(0);

        //Creamos la variable index
        int index = 0;

        //Asignamos la posición actual al aterrizaje
        int posicionActual = aterrizaje;

        //Mostramos el orden de los portales a los que irá
        ordenPortales(portales, distancia, portal, index, posicionActual);
    }
}