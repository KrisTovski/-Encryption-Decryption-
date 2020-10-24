package encryptdecrypt;

public class CipherContext {

    private EncryptDecryptMethod method;

    public void setMethod(EncryptDecryptMethod method) {
        this.method = method;
    }

    public String encrypt(String message, int key) {
        return this.method.encrypt(message, key);
    }

    public String decrypt(String message, int key) {
        return this.method.decrypt(message,key);
    }
}
