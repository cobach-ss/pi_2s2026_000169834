package util;

import java.util.Scanner;

public class Validador {
    public static int leerEntero(Scanner scanner, String mensaje) {
    int valor = 0;
    boolean valido = false;
    while (!valido) {
        System.out.print(mensaje);
        try {
            valor = Integer.parseInt(scanner.nextLine().trim());
            valido = true;
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero entero valido.");
        }
    }
    return valor;
}

    public static boolean validarNivelPoder(int nivel) {
        return nivel >= 1 && nivel <= 100;
    }

    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean validarOpcion(int opcion, int min, int max) {
        return opcion >= min && opcion <= max;
    }
}
