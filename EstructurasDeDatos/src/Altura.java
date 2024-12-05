import java.util.ArrayList;
import java.util.Scanner;

public class Altura {
    public static int numeroAlumnos(Scanner s) {
        System.out.print("Cuántos alumnos hay en la clase?: ");
        return s.nextInt();
    }

    public static void leerAlturas(ArrayList<Double> alturas, int numeroAlumnos, Scanner s) {
        double altura;
        for (int i = 0; i < numeroAlumnos; i++) {
            System.out.print("Introduce la altura del alumno " + (i + 1) + ": ");
            altura = s.nextDouble();
            alturas.add(altura);
        }
    }

    public static double calcularMedia(ArrayList<Double> alturas) {
        double sumaTotal = 0;
        for (double altura : alturas) {
            sumaTotal += altura;
        }
        return sumaTotal / alturas.size();
    }

    public static int calcularAlumnosAlturaSuperior(ArrayList<Double> alturas, double media) {
        int alumnosAlturaSuperior = 0;
        for (double altura : alturas) {
            if (altura > media) alumnosAlturaSuperior++;
        }
        return alumnosAlturaSuperior;
    }

    public static int calcularAlumnosAlturaInferior(ArrayList<Double> alturas, double media) {
        int alumnosAlturaInferior = 0;
        for (double altura : alturas) {
            if (altura < media) alumnosAlturaInferior++;
        }
        return alumnosAlturaInferior;
    }

    public static void mostrarResultados(ArrayList<Double> alturas, double media) {
        System.out.println("Las alturas son: " + alturas);
        System.out.printf("La media de las alturas es %.2f", media);
        System.out.printf("\nHay %d alumno/s con una altura superior a la media", calcularAlumnosAlturaSuperior(alturas, media));
        System.out.printf("\nHay %d alumno/s con una altura inferior a la media", calcularAlumnosAlturaInferior(alturas, media));
    }

    public static void main(String[] args){
        //Creamos la array list con alturas (vacia)
        ArrayList<Double> alturas = new ArrayList<>();

        //Creamos el Scanner
        Scanner s = new Scanner(System.in);

        //Preguntamos cuántos alumnos hay en clase
        int numeroAlumnos = numeroAlumnos(s);

        //Preguntamos las alturas de todos los alumnos
        leerAlturas(alturas, numeroAlumnos, s);

        //Calculamos la media de las alturas
        double media = calcularMedia(alturas);

        //Mostramos los resultados (alturas, media, y la cantidad de alumnos con una altura superior/inferior a la media)
        mostrarResultados(alturas, media);

        //Cerramos el Scanner
        s.close();
    }
}
