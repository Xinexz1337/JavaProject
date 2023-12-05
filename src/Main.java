import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

class Derivative {
    public int int_k1;
    public int int_k2_1, int_k2_2, int_p2_2, int_k2_3, int_p2_3;
    public int int_k3_1, int_p3_1;
    public String operation;
    public String menu = "\nop.1 Pierwsze zadanie\nop.2 Drugie zadanie\nop.3 Trzecie zadanie\nop.4 Exit";
    public String introduction_note = "\nHello! " +
            "\nThis program calculates derivatives of given functions. To start using the program, type 'op.' followed" +
            "by the number corresponding to the desired function.";

    public static int checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            Main.printStr("Enter valid int: ");
            scanner.next();
        }

        int scan_result = scanner.nextInt();
        return scan_result;
    }
    public String makeZd1(int k1_x) {
        String note = "We have original function y = " + k1_x + "√x";
        Main.printStr(note);

        double p1_x = 0.5f;

        String zd1Res = k1_x * p1_x + "*x^(" + (p1_x - 1) + ")";
        return zd1Res;
    }

    public String makeZd2(int k2_x_1, int k2_x_2, int p2_x_2, int k2_x_3, int p2_x_3) {
        String note = "We have original function y = " + k2_x_1 + "√x + " + k2_x_2 + "x^(+ " + p2_x_2 + ") " + k2_x_3 + "x^(" + p2_x_3 + ")";
        Main.printStr(note);

        double p2_x_1 = 0.5f;

        String zd2Res = k2_x_1 * p2_x_1 + "*x^(" + (p2_x_1 - 1) + ") + " + k2_x_2 * p2_x_2 + "*x^(" + (p2_x_2 - 1) + ") + " + k2_x_3 * p2_x_3 + "*x^(" + (p2_x_3 - 1) + ")";
        return zd2Res;
    }

    public String makeZd3(int k3_x, int p3_x) {
        String note = "We have original function " + k3_x + " / (x^" + p3_x + ")";
        Main.printStr(note);

        p3_x = -p3_x;

        String zd3Res = k3_x * p3_x + " * x^(" + (p3_x - 1) + ")";
        return zd3Res;
    }
}

public class Main {

    static boolean run = true;

    public static void printStr(String str) {
        System.out.println(str);
    }

    public static void menu(String menu) {
        printStr(menu);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Derivative drv = new Derivative();

        printStr(drv.introduction_note);

        do {
            menu(drv.menu);
            drv.operation = scanner.next();

            try {
                switch (drv.operation) {
                    case "op.1":
                        printStr("You choose y = √x." +
                                "\nEnter the coefficient in front of √x (only int type): ");
                        drv.int_k1 = drv.checkInt(scanner);
                        printStr("The result is: " + drv.makeZd1(drv.int_k1));
                        break;
                    case "op.2":
                        printStr("You choose y = √x + x^a + x^b" +
                                "\nEnter the coefficient in front of √x (only int type): ");
                        drv.int_k2_1 = drv.checkInt(scanner);

                        printStr("Enter the coefficient in front of x^a (only int type): ");
                        drv.int_k2_2 = drv.checkInt(scanner);
                        printStr("Enter the power (a):");
                        drv.int_p2_2 = drv.checkInt(scanner);

                        printStr("Enter the coefficient in front of x^b (only int type): ");
                        drv.int_k2_3 = drv.checkInt(scanner);
                        printStr("Enter the power (b):");
                        drv.int_p2_3 = drv.checkInt(scanner);

                        printStr("The result is: " + drv.makeZd2(drv.int_k2_1, drv.int_k2_2, drv.int_p2_2, drv.int_k2_3, drv.int_p2_3));
                        break;
                    case "op.3":
                        printStr("You choose a/(x^b)" +
                                "\nEnter the coefficient in front of x (only int type): ");
                        drv.int_k3_1 = drv.checkInt(scanner);
                        printStr("Enter the power (b): ");
                        drv.int_p3_1 = drv.checkInt(scanner);
                        printStr("The result is: " + drv.makeZd3(drv.int_k3_1, drv.int_p3_1));
                        break;
                    case "op.4":
                        printStr("\nThanks for testing my project.");
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid");
                }
            }
            catch (InputMismatchException e) {
                printStr(e.getMessage());
            }
        } while (run == true);

        scanner.close();
    }
}