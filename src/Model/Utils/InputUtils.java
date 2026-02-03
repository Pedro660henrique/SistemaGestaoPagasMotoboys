package Model.Utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class InputUtils {

    private InputUtils() {
        // impede instanciação
    }

    // ==============================
    // STRING
    // ==============================
    public static String lerString(Scanner sc, String mensagem) {
        String texto;

        do {
            System.out.print(mensagem);
            texto = sc.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Entrada inválida. Digite um texto válido.");
            }

        } while (texto.isEmpty());

        return texto;
    }

    // ==============================
    // INT
    // ==============================
    public static int lerInt(Scanner sc, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = sc.nextLine().trim();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    // ==============================
    // BIGDECIMAL (VALOR MONETÁRIO)
    // ==============================
    public static BigDecimal lerBigDecimal(Scanner sc, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = sc.nextLine()
                        .trim()
                        .replace("R$", "")
                        .replace(".", "")
                        .replace(",", ".");

                BigDecimal valor = new BigDecimal(entrada);

                if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("O valor deve ser maior que zero.");
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Exemplo válido: 10,50");
            }
        }
    }

    // ==============================
    // S / N
    // ==============================
    public static char lerSN(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim().toLowerCase();

            if (entrada.equals("s") || entrada.equals("n")) {
                return entrada.charAt(0);
            }

            System.out.println("Resposta inválida. Digite 's' ou 'n'.");
        }
    }

    // ==============================
    // FORMATAR VALOR (EXIBIÇÃO)
    // ==============================
    public static String formatarMoeda(BigDecimal valor) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("R$ #,##0.00", symbols);
        return df.format(valor);
    }

    public static String lerHorario(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String horario = sc.nextLine().trim();

            if (horario.matches("^([01]\\d|2[0-3]):[0-5]\\d$")) {
                return horario;
            }

            System.out.println("Horário inválido. Use o formato HH:mm (ex: 11:00).");
        }
    }
}
