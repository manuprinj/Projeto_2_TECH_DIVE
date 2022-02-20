package utils;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class InputUtils {

    public static final Scanner SC = new Scanner(System.in);
    public static final String VALOR_INVALIDO = "Valor inválido!";

    public static double getDouble(String mensagem) {
        Double valor = null;
        while (valor == null) {
            System.out.println(mensagem);
            try {
                valor = Double.parseDouble(SC.nextLine().replace(",", "."));
            } catch (Exception e) {
                System.out.println(VALOR_INVALIDO);
            }
        }
        return valor;
    }

    public static int getInt() {
        Integer valor = null;
        while (valor == null) {
            try {
                valor = Integer.parseInt(SC.nextLine());
            } catch (Exception e) {
                System.out.println(VALOR_INVALIDO);
            }
        }
        return valor;
    }

    public static String getString(String mensagem) {
        String valor = "";
        while (valor.isBlank()) {
            System.out.println(mensagem);
            valor = SC.nextLine();
        }
        return valor;
    }

    public static String getCPF(String mensagem) {
        String cpf = "";
        while (!CPFUtils.isCPFValido(cpf)) {
            System.out.println(mensagem);
            cpf = SC.nextLine();
        }
        return cpf;
    }

    public static String getCNPJ(String mensagem) {
        String cnpj = "";
        while (!CNPJUtils.isCNPJValido(cnpj)) {
            System.out.println(mensagem);
            cnpj = SC.nextLine();
        }
        return cnpj;
    }

    public static LocalDate getData(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                return DateUtils.parse(SC.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida, digite a data no formato dd/MM/yyyy");
            }
        }
    }

    public static String getSenha(String mensagem) {
        String senha = "";
        while (!SenhaUtils.isSenhaValida(senha)) {
            System.out.println(mensagem);
            senha = SC.nextLine();
        }
        return senha;
    }

    public static String getEmail(String mensagem) {
        String email = "";
        while (!EmailUtils.isEmailValido(email)) {
            System.out.println(mensagem);
            email = SC.nextLine();
        }
        return email;
    }
}
