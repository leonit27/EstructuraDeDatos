import java.util.Scanner;
import java.util.Stack;

public class Paréntesis {
    public static String introducirCadena(Scanner s) {
        System.out.print("Introduce una cadena parentizada: ");
        return s.nextLine();
    }

    public static boolean esBalanceado(Stack stack1, String cadena, boolean balanceado) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ')' || cadena.charAt(i) == ']' || cadena.charAt(i) == '}') {
                if (stack1.isEmpty()) {
                    balanceado = false;
                    break;
                }
            }
            if (cadena.charAt(i) == '(') stack1.push('(');
            if (cadena.charAt(i) == '[') stack1.push('[');
            if (cadena.charAt(i) == '{') stack1.push('{');

            if (cadena.charAt(i) == ')') {
                if (stack1.peek().equals('(')) stack1.pop();
            }
            if (cadena.charAt(i) == ']') {
                if (stack1.peek().equals('[')) stack1.pop();
            }
            if (cadena.charAt(i) == '}') {
                if (stack1.peek().equals('{')) stack1.pop();
            }
        }

        if (!stack1.isEmpty()) balanceado = false;

        return balanceado;
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack();

        boolean balanceado = true;

        Scanner s = new Scanner(System.in);

        String cadena = introducirCadena(s);

        balanceado = esBalanceado(stack1, cadena, balanceado);

        if (balanceado) System.out.println("La cadena está bien parentizada");
        else System.out.println("La cadena no está bien parentizada");
    }
}