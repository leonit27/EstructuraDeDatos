import java.util.Scanner;
import java.util.Stack;

public class ExpresionesAritmeticas {
    public static void main(String[] args) {
        Stack<Character> stack1 = new Stack();

        Scanner s = new Scanner(System.in);

        System.out.print("Introduce una expresion con notación postfija: ");
        String expresion = s.nextLine();

        expresion = expresion.replaceAll(" ", "");

        int i = 0;

        while (i < expresion.length() - 1) {
            while (Character.isDigit(expresion.charAt(i))) {
                stack1.push(expresion.charAt(i));
                i++;
            }

            System.out.println(stack1);

            char num2 = stack1.pop();
            char num1 = stack1.pop();

            switch(expresion.charAt(i)) {
                case '+':
                    stack1.push((char) (num1 + num2));
                    break;
                case '-':
                    //stack1.push(num1 - num2);
                    break;
                case '*':
                    //stack1.push(num1 * num2);
                    break;
                case '/':
                    //stack1.push(num1 / num2);
                    break;
                default:
                    break;
            }

            System.out.print(stack1);
        }
    }
}