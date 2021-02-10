import java.util.Scanner;
public class Settings {
    public static boolean simple_mode = true;
    public static boolean viet_theorem = false;
    public static String value;
    static String choose;
    static void refresh() {
        for (int x = 0; x < 100; x++) {
            System.out.println();
        }
        System.out.print(Calc.line +"\n2. Simple mode: ");
        if (simple_mode)
            System.out.println("On");
        else
            System.out.println("Off");
        System.out.print("1. Viet Theorem: ");
        if (viet_theorem)
            System.out.println("On");
        else
            System.out.println("Off");
        System.out.println("0. Exit");
        System.out.print(Calc.line);
    }
    public static void settings() {
        Scanner scanner = new Scanner(System.in);
        refresh();
        while (true) {
        System.out.print("\nChoose: ");
        choose = scanner.next();
            switch (choose) {
                case "2":
                    System.out.print("Option (On/Off): ");
                    value = scanner.next();
                    System.out.println(Calc.line);
                    if (value.toLowerCase().equals("on"))
                        simple_mode = true;
                    else if (value.toLowerCase().equals("off")) {
                        simple_mode = false;
                        if (viet_theorem)
                            viet_theorem = false;
                    }
                    refresh();
                    break;
                case "1":
                    System.out.print("Option (On/Off): ");
                    value = scanner.next();
                    System.out.println(Calc.line);
                    if (value.toLowerCase().equals("on"))
                        viet_theorem = true;
                    if (!simple_mode) {
                        simple_mode = true;
                    } else if (value.toLowerCase().equals("off"))
                        viet_theorem = false;
                    refresh();
                    break;
                case "0":
                    for (int x = 0; x < 100; x++) {
                        System.out.println();
                    }
                    return;
                default:
                    System.out.println("Wrong");
                    try {
                        Thread.sleep(2000);
                        for (int x = 0; x < 100; x++) {
                            System.out.println();
                        }
                        return;
                    }
                    catch (InterruptedException e) {
                        System.exit(0);
                    }
            }
        }
    }
}
