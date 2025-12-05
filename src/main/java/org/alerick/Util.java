package org.alerick;

public class Util {

    /**
     * Formats a given String to titlecase.
     * @param str The string.
     * @return The string in titlecase.
     */
    public static String toTitleCase(String str) {
        if (str == null) {
            return null;
        } else if (str.equals("")) {
            return "";
        } else if (str.equals(" ")) {
            return " ";
        }

        String strOut = "";
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].substring(0, 1).toUpperCase() +
                    strs[i].substring(1).toLowerCase();
            if (i != strs.length - 1) {
                strOut += strs[i] + " ";
            } else {
                strOut += strs[i];
            }
        }
        return strOut;
    }
}
