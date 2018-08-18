package com.common.utils;

import android.support.annotation.NonNull;

public final class Strings {
    @NonNull
    public static final String EMPTY = "";
    @NonNull
    public static final String LINE_BREAK = "\n";
    @NonNull
    public static final String AUTHORIZATION = "Authorization";
    @NonNull
    public static final String TOKEN = "Token token=";
    @NonNull
    public static final String STRING_EMPTY = "";
    @NonNull
    public static final String DOT = ".";
    @NonNull
    public static final String SPACE = " ";
    @NonNull
    public static final String COMA = ", ";
    public static final String COLON = ":";
    @NonNull
    public static final String COLON_WITH_SPACE = SPACE + COLON + SPACE;
    @NonNull
    public static final String COLON_HYPHEN = " :- ";
    @NonNull
    public static final String UNDER_SCORE = "_";


    private Strings() {
        // No instances.
    }

    public static boolean isBlank(CharSequence string) {
        return (string == null || string.toString().trim().length() == 0);
    }

    public static boolean isNull(CharSequence string) {
        return (string == null || string.toString().trim().length() == 0 || string.equals("null"));
    }

    public static String valueOrDefault(String string, String defaultString) {
        return isBlank(string) ? defaultString : string;
    }

    public static String valueOrEmpty(String string) {
        return isBlank(string) ? EMPTY : string;
    }

    public static String truncateAt(String string, int length) {
        return string.length() > length ? string.substring(0, length) : string;
    }

    public static boolean isProperEmail(String string) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(string).matches();
    }

    public static boolean isProperPassword(CharSequence string) {
        return (string == null || string.toString().length() < 5);
    }

    public static boolean isProperFileName(String string) {
        return !isBlank(string) && !string.contains(DOT) && !isAlphaNumeric(string);
    }

    public static boolean isAlphaNumeric(String string) {
        return (string.matches(".*\\W{1,}.*"));
    }
}
