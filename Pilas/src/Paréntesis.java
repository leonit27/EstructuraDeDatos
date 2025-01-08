import java.util.Scanner;
import java.util.Stack;

public class Paréntesis {
    public static void main(String[] args) {
        Stack stack1 = new Stack();

        Scanner s = new Scanner(System.in);

        System.out.print("Introduce una cadena parentizada: ");
        String cadena = s.nextLine();

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') stack1.push('(');
            if (cadena.charAt(i) == ')') {
                //stack1.push(')');
                stack1.search(')');
            }
        }

        System.out.println(stack1);
    }
}