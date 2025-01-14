import java.util.Scanner;
import java.util.Stack;

public class ExpresionesAritmeticas {
    public static String introducirExpresion(Scanner s) {
        System.out.print("Introduce una expresion con notación postfija: ");
        String expresion = s.nextLine();

        return expresion.replaceAll(" ", "");
    }

    public static void evaluarExpresion (String expresion, Stack<Integer> stack1) {
        int i = 0;

        if (expresion.length() == 1) {
            stack1.push(Character.getNumericValue(expresion.charAt(i)));
            System.out.println(stack1);
        } else {
            while (i < expresion.length()) {
                while (Character.isDigit(expresion.charAt(i))) {
                    stack1.push(Character.getNumericValue(expresion.charAt(i)));
                    i++;
                }

                int num2 = stack1.pop();
                int num1 = stack1.pop();

                switch(expresion.charAt(i)) {
                    case '+':
                        stack1.push(num1 + num2);
                        break;
                    case '-':
                        stack1.push(num1 - num2);
                        break;
                    case '*':
                        stack1.push(num1 * num2);
                        break;
                    case '/':
                        stack1.push(num1 / num2);
                        break;
                    default:
                        break;
                }
                i++;
            }
            System.out.print(stack1);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack();

        Scanner s = new Scanner(System.in);

        String expresion = introducirExpresion(s);

        evaluarExpresion(expresion, stack1);
    }
}