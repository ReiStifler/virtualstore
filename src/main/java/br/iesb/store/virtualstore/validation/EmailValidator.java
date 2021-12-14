package br.iesb.store.virtualstore.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_PATTERN = "^(?=.*[0-9])(?=.*[@]).{5,200}.*$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}

//“^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$”
