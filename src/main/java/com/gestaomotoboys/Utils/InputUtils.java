package com.gestaomotoboys.Utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtils {

    public static int lerInt(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Número inválido.");
            }
        }
    }

    public static BigDecimal lerBigDecimal(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return new BigDecimal(sc.nextLine().replace(",", "."));
            } catch (Exception e) {
                System.out.println("Valor inválido.");
            }
        }
    }

    public static String lerString(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    public static String lerHorario(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String h = sc.nextLine();

            if (h.matches("^([01]\\d|2[0-3]):[0-5]\\d$"))
                return h;

            System.out.println("Horário inválido (HH:mm)");
        }
    }

    public static char lerSN(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextLine().toLowerCase().charAt(0);
    }
}

