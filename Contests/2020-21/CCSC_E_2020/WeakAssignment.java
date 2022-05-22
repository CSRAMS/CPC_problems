import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WeakAssignment {
    public static class Equation {
        String equation;
        HashSet<String> dependencies;


        public Equation(int dependencies) {
            this.equation = null;
            this.dependencies = new HashSet<>();
        }

        @Override
        public String toString() {
            return "Equation{" +
                    "eq='" + equation + '\'' +
                    ", deps=" + dependencies +
                    '}';
        }

        public int calculate() {
            int length = equation.length();
            if (length == 0) return 0;
            int currentNumber = 0, lastNumber = 0, result = 0;
            char operation = '+';
            for (int i = 0; i < length; i++) {
                char currentChar = equation.charAt(i);
                if (Character.isDigit(currentChar)) {
                    currentNumber = (currentNumber * 10) + (currentChar - '0');
                }
                if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                    if (operation == '+' || operation == '-') {
                        result += lastNumber;
                        lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                    } else if (operation == '*') {
                        lastNumber = lastNumber * currentNumber;
                    } else if (operation == '/') {
                        lastNumber = lastNumber / currentNumber;
                    }
                    operation = currentChar;
                    currentNumber = 0;
                }
            }
            result += lastNumber;
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("quit")) {
            HashMap<String, Equation> equations = new HashMap<>();

            String[] raw = input.split(" <- ");
            String desiredOut = raw[0];
            for (String rawEquation : raw[1].split(" ; ")) {
                raw = rawEquation.split(" = ");
                Equation equation = equations.compute(raw[0], (k, v) -> v == null ? new Equation(0) : v);
                equation.equation = raw[1];
                for (String var : raw[1].split( " ")) {
                    if(!var.matches("[a-zA-Z]+"))
                        continue;
                    Equation varEq = equations.compute(var, (k, v) -> v == null ? new Equation(0) : v);
                    varEq.dependencies.add(var);
                }
            }
            System.out.println(equations);

            input = scanner.nextLine();
        }

    }
}
