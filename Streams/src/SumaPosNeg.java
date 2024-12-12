import java.util.ArrayList;
import java.util.List;

public class SumaPosNeg {
    public static void main(String[] args) {
        List<String> numeros = new ArrayList<>();

        numeros.add("25");
        numeros.add("30");
        numeros.add("-54");

        //Contamos los positivos
        long cuantosPos = numeros.stream()
                //convertimos a Int
                .mapToInt(s -> Integer.valueOf(s))
                //filtramos los que sean positivos
                .filter(number -> number > 0)
                //y los contamos
                .count();

        //Contamos los negativos
        long cuantosNeg = numeros.stream()
                //convertimos a Int
                .mapToInt(s -> Integer.valueOf(s))
                //filtramos los que sean negativos
                .filter(number -> number < 0)
                //y los contamos
                .count();

        System.out.println("Hay " + cuantosPos + " positivos y " + cuantosNeg + " negativos");
    }
}