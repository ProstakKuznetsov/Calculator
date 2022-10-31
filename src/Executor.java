import static java.lang.System.exit;

/*
    Класс с основными проверками и подсчетом. Сюда передаются данные после проверки на Арабские или Римские цифры
 */
class Executor {
    static int result;

    static int getResult(int firstNumber, int secondNumber, char operator) throws CalculatorException {
        try {
            // Проверяем на соблюдение условия от 1 до 10
            if (firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) {
                throw new CalculatorException("Ошибка ввода. Используйте числа от 1 до 10 включительно. ");
            }

            // Определяем какое действие будем производить
            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
                default:
                    throw new CalculatorException("Используйте арифметические операторы из списка: + - * / ");
            }
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Проверьте правильность введенных данных. Используйте целые числа. ");
        }
        return result;
    }
}