package com.cauesobral.vitalis.util;

public class CpfUtils {

    private CpfUtils() {
    }

    public static boolean isValid(String cpf) {
        if (cpf == null) return false;

        String cleaned = cpf.replaceAll("[.\\-]", "");

        if (cleaned.length() != 11) return false;

        if (cleaned.chars().distinct().count() == 1) return false;

        int firstDigit = calculateDigit(cleaned, 9);
        if (firstDigit != Character.getNumericValue(cleaned.charAt(9))) return false;

        int secondDigit = calculateDigit(cleaned, 10);
        return secondDigit == Character.getNumericValue(cleaned.charAt(10));
    }

    private static int calculateDigit(String cpf, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (length + 1 - i);
        }
        int remainder = (sum * 10) % 11;
        return (remainder == 10 || remainder == 11) ? 0 : remainder;
    }
}
