package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) throws IOException {
        int key = 0;
        String data = "";
        String out = "";
        String dataFromFile = "";
        String mode = Action.ENCRYPT.name();
        String msg = "";
        String alg = Cipher.SHIFT.name();

        CipherContext context = new CipherContext();


        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {

                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    String filename = args[i + 1];
                    dataFromFile = new String(Files.readAllBytes(Paths.get(filename)));
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }

        msg = data;

        if (data.equals("") && dataFromFile.equals("")) {
            msg = "";
        }

        if (data.equals("") && !(dataFromFile.equals(""))) {
            msg = dataFromFile;
        }
        String result = "";

        switch (Cipher.findByValue(alg)) {
            case SHIFT:
                switch (Action.findByValue(mode)) {
                    case ENCRYPT:
                        context.setMethod(new CaesarCipher());
                        result = context.encrypt(msg, key);
                        break;
                    case DECRYPT:
                        context.setMethod(new CaesarCipher());
                        result = context.decrypt(msg, key);
                        break;
                }
                break;
            case UNICODE:
                switch (Action.findByValue(mode)) {
                    case ENCRYPT:
                        context.setMethod(new UnicodeCipher());
                        result = context.encrypt(msg, key);
                        break;
                    case DECRYPT:
                        context.setMethod(new UnicodeCipher());
                        result = context.decrypt(msg, key);
                        break;
                }
                break;


        }
        if (!out.equals("")) {
            File file = new File(out);

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(result);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(result);
        }

    }
}
