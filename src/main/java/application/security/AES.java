package application.security;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;


public class AES {
    // AES 128  ECB
    private static final byte[] key = "testaesKEY0value".getBytes(StandardCharsets.UTF_8);
    private static final String ALGORITHM = "AES";


    public static void main (String[] args) throws Exception
    {
        String str = "123456789asdtestTE!@#$%^&*()+{}:?<~` `";
        AES aesTest = new AES();

        String enc = aesTest.encrypt(str);
        System.out.println(enc);
        String decrypt = aesTest.decrypt(enc);
        System.out.println(decrypt);
    }

    public AES()
    {

    }

    public String encrypt(String encryptStr) throws Exception
    {
        byte[] textToEncrypt = encryptStr.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        textToEncrypt = cipher.doFinal(textToEncrypt);
        return  Base64.encodeBase64String(textToEncrypt);

    }

    public String decrypt(String decryptStr) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypt = cipher.doFinal(Base64.decodeBase64(decryptStr));
        return new String(decrypt);
    }

}
