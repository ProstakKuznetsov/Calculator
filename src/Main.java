import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString;
        // вызываем метод кулькулятора и зацикливаем до выхода или исключения
        while (true) {
            System.out.println("Введите пример используя Арабские или Римские числа от 1 до 10 включительно (+ - * /)");
            inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye");
                exit(0);
            }
            System.out.println(calc(inputString));
        }
    }

    public static String calc(String input) {
        String result = "";

        String[] inputOperator = input.split("\\s");
        try {
            // Проверяем на количество введенных чисел
            if (inputOperator.length != 3) {
                throw new CalculatorException("Ошибка ввода. Следуйте примеру \"1 + 2\". ");
            }
            try {
                result = String.valueOf(Calculator.getResultArabic(inputOperator));
            } catch (Exception e) {
                result = Calculator.getResultRoman(inputOperator);
            }
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            exit(0);
        }
        return result;
    }
}