package Service;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtils {
    public static int lerInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    public static BigDecimal lerBigDecimal(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String s = sc.nextLine().replace(",", ".");
                return new BigDecimal(s);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Ex: 12,50");
            }
        }
    }

    public static char lerSN(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("s") || s.equals("n")) {
                return s.charAt(0);
            }
            System.out.println("Responda com 's' ou 'n'.");
        }
    }
}
