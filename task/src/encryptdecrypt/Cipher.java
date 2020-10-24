package encryptdecrypt;

public enum Cipher {

    SHIFT ("shift"),
    UNICODE ("unicode");

    String cipherDescription;

    Cipher(String cipherDescription) {
        this.cipherDescription = cipherDescription;
    }

    public String getCipherDescription() {
        return cipherDescription;
    }

    public static Cipher findByValue(String dec) {
        for (Cipher value : values()) {
            if (dec.equals(value.cipherDescription)) {
                return value;
            }
        }
        return null;
    }
}
