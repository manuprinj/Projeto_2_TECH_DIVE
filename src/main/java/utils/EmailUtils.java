package utils;


import java.util.regex.Pattern;


public class EmailUtils {

    private static final String REGEX_EMAIL = "^\\S+@\\S+\\.\\S+$";
    private static final Pattern PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL, Pattern.CASE_INSENSITIVE);

    public static boolean isEmailValido(String email) {
        if (email == null || email.length() <= 0) return false;
        return PATTERN_EMAIL.matcher(email).matches();
    }
}
