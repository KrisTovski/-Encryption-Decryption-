package encryptdecrypt;

public interface EncryptDecryptMethod {

    String decrypt(String message, int key);

    String encrypt(String message, int key);
}
