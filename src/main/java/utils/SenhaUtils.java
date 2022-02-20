package utils;


public class SenhaUtils {

    public static boolean isSenhaValida(String senha) {
        boolean numero = false;
        boolean letra = false;

        if (senha.length() >= 8) return false;

        for (char caracter : senha.toCharArray()) {
            if (caracter >= '0' && caracter <= '9') {
                numero = true;
            } else if (caracter >= 'A' && caracter <= 'Z' || caracter >= 'a' && caracter <= 'z') {
                letra = true;
            }
        }
        return numero && letra;
    }
}
