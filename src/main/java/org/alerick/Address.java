package org.alerick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Address {
    @Setter private Integer streetNo;
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;


    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
        } else {
            this.postalCode = null;
            this.streetNo = null;
            this.street = null;
            this.city = null;
            this.province = null;
        }
    }

    /**
     * Checks if a given postal code is in the right format (A1B2C3)
     * @param postalCode the postal code
     * @return if the postal code is valid
     */
    private static boolean isPostalCodeValid(String postalCode) { // how to test if private?
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }
        for (int i = 0; i < postalCode.length() - 1; i += 2) {
            Character c = postalCode.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        for (int i = 1; i < postalCode.length() - 1; i += 2) {
            Character c = postalCode.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.postalCode = null;
        }
    }

    public enum Province {
        AB, BC, MB, NB, NL, NS, ON, PE, QC, SK, NT, NU, YT
    }
}
