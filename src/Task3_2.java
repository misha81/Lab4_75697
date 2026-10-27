import java.util.Scanner;

public class Task3_2 {

    private static final int[] ALLOWED_BASES = {2, 3, 4, 5, 6, 8, 9, 10, 16};

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choice;

        do {
            printMenu();
            choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    convertToDecimal();
                    break;
                case "B":
                    convertFromDecimal();
                    break;
                case "C":
                    calculate('+');
                    break;
                case "D":
                    calculate('-');
                    break;
                case "E":
                    calculate('*');
                    break;
                case "F":
                    calculate('/');
                    break;
                case "W":
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Unknown option, please try again.");
            }
        } while (!choice.equals("W"));

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("Choose what operation you want to perform:");
        System.out.println();
        System.out.println("A. Convert from any system to the decimal system");
        System.out.println("B. Convert from decimal system to another system");
        System.out.println("C. Summing up numbers from different systems");
        System.out.println("D. Subtracting numbers from different systems");
        System.out.println("E. Multiplying numbers from different systems");
        System.out.println("F. Dividing numbers from different systems");
        System.out.println();
        System.out.println("W. Exit the program");
    }

    private static void convertToDecimal() {
        int base = readBase("Enter the system of your number " + basesList() + ": ");
        Long number = readNumber("Enter the number: ", base);
        if (number == null) {
            return;
        }
        System.out.println("Decimal value: " + number);
    }

    private static void convertFromDecimal() {
        Long number = readNumber("Enter the decimal number: ", 10);
        if (number == null) {
            return;
        }
        int base = readBase("Enter the target system " + basesList() + ": ");
        System.out.println("Result in system " + base + ": " + toBase(number, base));
    }

    private static void calculate(char operator) {
        int base1 = readBase("Enter the system of the first number " + basesList() + ": ");
        Long first = readNumber("Enter the first number: ", base1);
        if (first == null) {
            return;
        }

        int base2 = readBase("Enter the system of the second number " + basesList() + ": ");
        Long second = readNumber("Enter the second number: ", base2);
        if (second == null) {
            return;
        }

        int resultBase = readBase("Enter the system for the result " + basesList() + ": ");

        long result;
        switch (operator) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            default:
                if (second == 0) {
                    System.out.println("Cannot divide by zero.");
                    return;
                }
                result = first / second; // integer division
        }

        System.out.println("Result in system " + resultBase + ": " + toBase(result, resultBase));
    }

    private static Long readNumber(String prompt, int base) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        try {
            return Long.parseLong(input, base);
        } catch (NumberFormatException e) {
            System.out.println("\"" + input + "\" is not a valid number in system " + base + ".");
            return null;
        }
    }

    private static int readBase(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int base = Integer.parseInt(input);
                for (int allowed : ALLOWED_BASES) {
                    if (allowed == base) {
                        return base;
                    }
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Please choose one of: " + basesList());
        }
    }

    private static String toBase(long value, int base) {
        return Long.toString(value, base).toUpperCase();
    }

    private static String basesList() {
        return "(2, 3, 4, 5, 6, 8, 9, 10, 16)";
    }
}