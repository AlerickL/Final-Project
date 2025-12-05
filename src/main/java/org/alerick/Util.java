package org.alerick;

public class Util {
    /**
     * Formats a given String to titlecase.
     * @param str The string.
     * @return The string in titlecase.
     */
    public String toTitleCase(String str) {
        String strOut = "";
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].substring(0, 1).toUpperCase() +
                    strs[i].substring(1).toLowerCase();
            strOut += strs[i] + " ";
        }
        return strOut;
    }
}
