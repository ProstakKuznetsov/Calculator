public class Calculator {
    static int result;
    static int firstNumber;
    static int secondNumber;
    static char operator;
    static Executor executor = new Executor();

    static int getResultArabic(String[] inputOperator) throws CalculatorException {

        firstNumber = Integer.valueOf(inputOperator[0]);
        secondNumber = Integer.valueOf(inputOperator[2]);
        operator = inputOperator[1].charAt(0);

        result = executor.getResult(firstNumber, secondNumber, operator);
        return result;

    }

    static String getResultRoman(String[] inputOperator) throws CalculatorException {

        int resultInteger;
        String resultString = "";

        try {
            firstNumber = RomanEnum.valueOf(inputOperator[0]).getArabicNumeral();
            secondNumber = RomanEnum.valueOf(inputOperator[2]).getArabicNumeral();
            operator = inputOperator[1].charAt(0);

            resultInteger = executor.getResult(firstNumber, secondNumber, operator);

        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new CalculatorException("Используйте только целые арабские или только римские цифры от 1 до 10 включительно. ");
        }

        if (resultInteger < 1) {
            throw new CalculatorException("Результат работы получился меньше единицы. Вывод невозможен. ");
        }

        RomanEnum[] romanArray = RomanEnum.values();
        for (RomanEnum romanDigit : romanArray) {
            if (romanDigit.arabicNumeral == resultInteger) {
                resultString = romanDigit.name();
                break;
            }
        }
        if (resultString.isEmpty()) {
            int tens = resultInteger / 10;
            int units = resultInteger - tens * 10;
            StringBuilder tensRoman = new StringBuilder("");
            StringBuilder unitsRoman = new StringBuilder("");
            tensAppend(tens, tensRoman);
            for (RomanEnum romanDigit : romanArray) {
                if (romanDigit.arabicNumeral == units) {
                    unitsRoman.append(romanDigit.name());
                    break;
                }
            }
            resultString = String.valueOf(tensRoman.append(unitsRoman));
        }
        return resultString;
    }

    static void tensAppend(int tens, StringBuilder tensRoman) {
        switch (tens) {
            case 1:
                tensRoman.append("X");
                break;
            case 2:
                tensRoman.append("XX");
                break;
            case 3:
                tensRoman.append("XXX");
                break;
            case 4:
                tensRoman.append("XL");
                break;
            case 5:
                tensRoman.append("L");
                break;
            case 6:
                tensRoman.append("LX");
                break;
            case 7:
                tensRoman.append("LXX");
                break;
            case 8:
                tensRoman.append("LXXX");
                break;
            case 9:
                tensRoman.append("XC");
                break;
            case 10:
                tensRoman.append("C");
                break;
        }
    }
}
