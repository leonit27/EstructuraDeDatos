import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ExpresionesAritmeticasC {
    public static String introducirExpresion(Scanner s) {
        System.out.print("Introduce una expresion con notación postfija: ");
        String expresion = s.nextLine();

        return expresion.replaceAll(" ", "");
    }

    public static void evaluarExpresion (String expresion, Queue<Integer> queue) {
        int i = 0;

        if (expresion.length() == 1) {
            queue.offer(Character.getNumericValue(expresion.charAt(i)));
            System.out.println(queue);
        } else {
            while (i < expresion.length()) {
                while (Character.isDigit(expresion.charAt(i))) {
                    queue.offer(Character.getNumericValue(expresion.charAt(i)));
                    i++;
                }

                int num1 = queue.poll();
                int num2 = queue.poll();

                switch(expresion.charAt(i)) {
                    case '+':
                        queue.offer(num1 + num2);
                        break;
                    case '-':
                        queue.offer(num1 - num2);
                        break;
                    case '*':
                        queue.offer(num1 * num2);
                        break;
                    case '/':
                        queue.offer(num1 / num2);
                        break;
                    default:
                        break;
                }
                i++;
            }
            System.out.print(queue);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        Scanner s = new Scanner(System.in);

        String expresion = introducirExpresion(s);

        evaluarExpresion(expresion, queue);
    }
}
