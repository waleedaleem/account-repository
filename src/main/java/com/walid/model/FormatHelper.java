package com.walid.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * A helper class with global field formatting methods (e.g. date and currency formatting)
 */
public class FormatHelper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(
            "dd/MM/yyyy");

    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();

    public static String formatCurrency(BigDecimal amount) {
        return CURRENCY_FORMATTER.format(amount);
    }

    public static String formatDate(LocalDate date) {
        if (Objects.nonNull(date)) {
            return date.format(DATE_FORMATTER);
        } else {
            return "";
        }
    }
}
