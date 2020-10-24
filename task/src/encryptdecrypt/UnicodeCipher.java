package encryptdecrypt;

public class UnicodeCipher implements EncryptDecryptMethod {

    @Override
    public String encrypt(String message, int key) {
        String result = "";
        for (char character : message.toCharArray()) {
            result += (char) ((int)character + key);
        }
        return result;
    }

    @Override
    public String decrypt(String message, int key) {
        String result = "";
        for (char character : message.toCharArray()) {
            result += (char) ((int) character - key);
        }
        return result;
    }


}
