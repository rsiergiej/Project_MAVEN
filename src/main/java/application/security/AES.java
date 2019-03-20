package application.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AES {


    private static final byte[] key = "testaesKEY0value".getBytes(StandardCharsets.UTF_8);
    private static final String ALGORITHM = "AES";

    public AES()
    {

    }

    public byte[] encrypt(String plainText) throws Exception
    {
        byte[] textToEncrypt = plainText.getBytes();

        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        textToEncrypt = cipher.doFinal(textToEncrypt);

        return  textToEncrypt;

    }


//    public byte[] encrypt(byte[] plainText) throws Exception
//    {
//
//
//        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
//        Cipher cipher = Cipher.getInstance(ALGORITHM);
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        return cipher.doFinal(plainText);
//    }


    public byte[] decrypt(byte[] cipherText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(cipherText);
    }
}
