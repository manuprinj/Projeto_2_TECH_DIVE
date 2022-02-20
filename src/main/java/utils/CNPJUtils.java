package utils;


import static utils.InputUtils.getCNPJ;

import java.util.InputMismatchException;


public class CNPJUtils {

    public static boolean isCNPJValido(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
            (cnpj.length() != 14))
            return(false);

        char dig13, dig14;
        int soma, i, resto, numero, peso;

        try {
            soma = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                numero = (cnpj.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            resto = soma % 11;
            if ((resto == 0) || (resto == 1))
                dig13 = '0';
            else dig13 = (char)((11-resto) + 48);

            soma = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                numero = (cnpj.charAt(i)- 48);
                soma = soma + (numero * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            resto = soma % 11;
            if ((resto == 0) || (resto == 1))
                dig14 = '0';
            else dig14 = (char)((11-resto) + 48);

            return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String getMascaraCNPJ(String cnpj) {
        return(cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." +
               cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" +
               cnpj.substring(12, 14));
    }

    public static boolean isCPFValido(String cnpj) {
        if (cnpj.length() != 14) return false;

        int multiplicador = 2;
        int soma = 0;
        int digitoVerficador1;
        int digitoVerficador2;


        for (int i = 11; i >= 0; i--) {
            int num = (cnpj.charAt(i) - 48) * multiplicador;
            soma += num;
            multiplicador++;
            if (multiplicador == 10) multiplicador = 2;
        }

        int resto = soma%11;
        if (resto >= 2) {
            digitoVerficador1 = 11 - resto;
        } else {
            digitoVerficador1 = 0;
        }

        soma = 0;
        multiplicador = 2;
        for (int i = 12; i >= 0; i--) {
            int num = (cnpj.charAt(i) - 48) * multiplicador;
            soma += num;
            multiplicador++;
            if (multiplicador == 10) multiplicador = 2;

        }

        resto = soma%11;
        if (resto >= 2) {
            digitoVerficador2 = 11 - resto;
        } else {
            digitoVerficador2 = 0;
        }

        return digitoVerficador1 == (cnpj.charAt(12) - 48) && digitoVerficador2 == (cnpj.charAt(13) - 48);
    }
}