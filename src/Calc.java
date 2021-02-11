import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Locale;
// 2 up unicode 00B2
// 2 down unicode 2082
// 1 down unicode 2081
// root unicode 221A
public class Calc {
    public static double a, b, c, dis, dis_root, x1, x2;
    static String a_str, string, buffer;
    public static String line = "==================================";
    static int length;
    static int buffer_length;
    static int string_length;
    static int length_compare;
    static int length_compare_reserve;
    static int show_solution_process_count = 1;
    public static boolean scan() {
        Scanner s = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.println(line);
        System.out.println("ax\u00b2 + bx + c = 0");
        System.out.println(line);
        System.out.print("a = ");
        a_str = s.next();
        try {
            a = Double.parseDouble(a_str);

        }
        catch (NumberFormatException exception) {
            if (a_str.toLowerCase().equals("settings"))
                Settings.settings();
            else if (a_str.toLowerCase().equals("exit")) {
                System.out.println(line);
                for (int x = 0; x < 4; x++)
                    System.out.println();
                System.exit(0);
            }
            else {
                System.out.println(line);
                System.out.println("Error 23: Not Number");
                System.out.println(line);
                for (int x = 0; x < 4; x++)
                    System.out.println();
            }
            return false;
        }
        try {
            System.out.print("b = ");
            b = s.nextDouble();
            System.out.print("c = ");
            c = s.nextDouble();
            System.out.println(line);
        }
        catch (InputMismatchException e) {
            System.out.println(line);
            System.out.println("Error 23: Not Number");
            System.out.println(line);
            for (int x = 0; x < 4; x++)
                System.out.println();
            return false;
        }
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Unlimited solutions");
                    System.out.println(line);
                    for (int x = 0; x < 4; x++)
                        System.out.println();
                    return false;
                }
                System.out.println("No Solution");
                System.out.println(line);
                for (int x = 0; x < 4; x++)
                    System.out.println();
                return false;
            }

                if (!Settings.simple_mode) {
                    buffer = String.format("       " + "%.2f", c);
                    string = String.format("       " + "%.2f", b);
                    buffer_length = buffer.length();
                    string_length = string.length();
                    length = Math.max(buffer_length - 5, string_length - 5);
                    System.out.println(buffer);
                    System.out.print("x = - ");
                    for (int x = 0; x < length; x++)
                        System.out.print("-");
                    System.out.println("\n" + string);
                    System.out.println(line);
                }

                System.out.println("x = " + -(c / b));
                System.out.println(line);

                for (int x = 0; x < 4; x++)
                    System.out.println();
                return false;
        }

        return true;
    }
    public static void print_detailed() {
        //======================================================================
        buffer = String.format("      " + "%.2f" + " + %.2f", -b, dis_root);
        buffer_length = buffer.length();
        string = String.format("      2.00 * %.2f", a);
        string_length = string.length();
        buffer = String.format("      " + "%.2f" + " + %.2f      %.2f", -b, dis_root, -b + dis_root);
        show_solution_process();
        //======================================================================
        buffer = String.format("      " + "%.2f" + " - %.2f", -b, dis_root);
        buffer_length = buffer.length();
        string = String.format("      2.00 * %.2f", a);
        string_length = string.length();
        buffer = String.format("      " + "%.2f" + " - %.2f      %.2f", -b, dis_root, -b - dis_root);
        show_solution_process();
        //=======================================================================
    }

    static void show_solution_process() {
        string = String.format("      2.00 * %.2f         %.2f", a, 2 * a);
        length_compare = (buffer.length() - buffer_length) - 3;
        length_compare_reserve = (string.length() - string_length) - 3;
        System.out.println(buffer);
        if (show_solution_process_count == 1)
            System.out.print("x\u2081 = ");
        else if (show_solution_process_count == 2) {
            System.out.print("x\u2082 = ");
        show_solution_process_count = 1;
        }
        for (int x = 0; x < buffer_length - 3; x++)
            System.out.print("-");
        System.out.print(" = ");
        length = Math.max(length_compare, length_compare_reserve);
        for (int y = 0; y < length - 1; y++) {
            System.out.print("-");
        }
        System.out.println("\n" + string);
        System.out.println(line);
        show_solution_process_count += 1;
    }

    public static void main(String[] args) {
        for (int x = 0; x < 100; x++) {
            System.out.println();
        }
            while (true) {
                if (!scan())
                    continue;
                dis = Math.pow(b, 2) - 4 * a * c;
                if (!Settings.viet_theorem && !Settings.simple_mode) {
                    System.out.println("D = " + b + "\u00b2 - 4 * " + a + " * " + c + "\n" +
                            "D = " + Math.pow(b, 2) + " - " + 4 * a * c);

                    dis_root = Math.sqrt(dis);
                }
                if (!Settings.viet_theorem) {
                        dis_root = Math.sqrt(dis);
                        System.out.println("D = " + dis);
                        if (!(dis < 0)) {
                            string = String.format("\u221aD = %.2f", dis_root);
                            System.out.println(string);
                        }
                }
                else {
                    System.out.println("x\u2081 + x\u2082 = " + -b + "\n" +
                                       "x\u2081 * x\u2082 = " + c);
                }
                if (dis < 0) {
                    System.out.println("No Solution");
                    System.out.println(line);
                    for (int x = 0; x < 4; x++)
                        System.out.println();
                    continue;
                }
                else if (dis > 0) {
                    x1 = (-b + dis_root) / (2 * a);
                    x2 = (-b - dis_root) / (2 * a);
                } else
                    x1 = x2 = -b / (2 * a);
                System.out.println(line);
                if (!Settings.simple_mode)
                    print_detailed();
                string = String.format("x\u2081 = %.2f", x1);
                System.out.println(string);
                string = String.format("x\u2082 = %.2f", x2);
                System.out.println(string + "\n" + line);
                for (int x = 0; x < 4; x++)
                    System.out.println();
            }
    }
}
