package application.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AEStest {


    public static void main (String[] args) throws Exception
    {

        ////////////////test convert//////////
        String str = "radek";
        byte[] bytetest = str.getBytes();
        System.out.println("String to byte[]: " + Arrays.toString(bytetest) + " << " + str);

        String strbytes = new String(bytetest);

        System.out.println("byte[] to String: " + strbytes);
        System.out.println("Wyżej wszystko działa");
        System.out.println("Teraz z szyfrowaniem");
        ////////////////test convert///END///////
        System.out.println("------------------------------------------");


        /////////////////////////////////AES SZYFROWANIE STRING>byte[]>STRING>byte[]///////////
        AEStest aesTest = new AEStest();
        System.out.println("Zaszyfrowane dane w hexie z kalkualtora z internetu: 72 B6 F3 2B 93 13 32 CE 20 E6 06 0F B1 0A C3 CF");
        byte[] aesByte = aesTest.encrypt(str);
        System.out.print("String przerobiony na na byte[] i nastepnie zaszyfrowany aesem, wynik jest w byte[]: ");
        for (byte b: aesByte)
        {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("");
        System.out.println("do tego miejsca wszystko sie zgadza teraz przerabiam byte[] na string żeby zapisać do bazy zaszyfrowane hasło");
        System.out.println("------------------------------------------");


        String aesString = new String(aesByte);
        System.out.println("Zaszyfrowany aesem byte[] to String wygląda tak: " + aesString);

        System.out.println("------------------------------------------");
        System.out.print("Zaszyfrowane string to byte[] :");
        byte[] aesStringtoByte = aesString.getBytes();
        for (byte b: aesStringtoByte)
        {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("");
        System.out.print("W tym miejscu nie zgadza się konwersja typów ponieważ aesStringtoByte nie jest równy aesByte");
        System.out.print("Nie wiem dlaczego");


    }


    private static final byte[] key = "testaesKEY0value".getBytes(StandardCharsets.UTF_8);
    private static final String ALGORITHM = "AES";

    public AEStest()
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
