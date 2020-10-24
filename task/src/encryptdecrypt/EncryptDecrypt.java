package encryptdecrypt;

public class EncryptDecrypt {

    public static final int ASCII_32 = 32;
    private static final int ALPHABET_SIZE = 126;


    public static String caesarDecrypt(String message, int key) {
        StringBuilder encoded = new StringBuilder();

        for (char c : message.toCharArray()) {
            char newChar = (char) ((c - key - ASCII_32) % ALPHABET_SIZE + ASCII_32);
            encoded.append(newChar);
        }
        encoded.append("\n");
        return encoded.toString();
    }

    public static String caesarEncrypt(String message, int key) {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            char newChar = (char) ((c + key - ASCII_32) % ALPHABET_SIZE + ASCII_32);
            decoded.append(newChar);
        }
        decoded.append("\n");
        return decoded.toString();
    }


}
