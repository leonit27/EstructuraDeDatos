import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EntreNumeros {
    public static void pedirNumeros(Scanner s, int num, ArrayList<Integer> numeros) {
        do {
            System.out.print("Introduce un número (para acabar introduce uno negativo): ");
            num = s.nextInt();
            if (num > 0) numeros.add(num);
        } while (num > 0);
    }

    public static void main(String[] args) {
        int num = 0;

        Scanner s = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        pedirNumeros(s, num, numeros);

        s.close();

        List<Integer> entreNumeros = numeros.stream()
                .filter(number -> number >= 1 && number <= 5)
                .collect(Collectors.toList());

        System.out.print("Los números son: ");
        System.out.println(entreNumeros);
    }
}
