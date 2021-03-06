package br.iesb.store.virtualstore.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String PASSWORD_PATTERN = "^.*(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$&*+=%]).{6,12}.*$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValid(final String password) {
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
