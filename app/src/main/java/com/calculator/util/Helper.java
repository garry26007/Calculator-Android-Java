package com.calculator.util;

import java.text.DecimalFormat;

public class Helper {

    public static String getResponsiveNumber(double data) {
        // Create a DecimalFormat instance to remove unnecessary decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setMinimumFractionDigits(0); // Ensure no trailing zeros
        decimalFormat.setMaximumFractionDigits(2); // Set an upper limit for fractional digits

        return decimalFormat.format(data);
    }
}
