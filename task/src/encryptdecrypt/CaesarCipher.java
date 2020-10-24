package encryptdecrypt;

public class CaesarCipher implements EncryptDecryptMethod {

    // public static final int ASCII_32 = 32;
    private static final int ALPHABET_SIZE = 26;

    public String encrypt(String message, int key) {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLowerCase(c)) {
                decoded.append((char) ((c + key - 'a') % ALPHABET_SIZE + 'a'));
            } else if (Character.isUpperCase(c)) {
                decoded.append((char) ((c + key - 'A') % ALPHABET_SIZE + 'A'));
            } else {
                decoded.append(c);
            }
        }
        decoded.append("\n");
        return decoded.toString();
    }

    public String decrypt(String message, int key) {
        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLowerCase(c)) {
                encoded.append((char) ((c - key - 'a' % ALPHABET_SIZE) % ALPHABET_SIZE + 'a'));
            } else if (Character.isUpperCase(c)) {
                encoded.append((char) ((c - key - 'A' % ALPHABET_SIZE) % ALPHABET_SIZE + 'A'));
            } else {
                encoded.append(c);
            }


        }
        encoded.append("\n");
        return encoded.toString();
    }


}
