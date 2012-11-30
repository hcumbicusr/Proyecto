package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encriptaCadenas {
       
    public static String MD5 = "MD5";
    
    private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(int i=0; i<digest.length; i++) {
            byte aux = digest[i];
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }
    public static String getStringMessageDigest(String message, String algorithm){
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest "+ex.getMessage());
        }
        return toHexadecimal(digest);
    } 
    
    public static void main(String[] args) {
        encriptaCadenas StringMD=new encriptaCadenas();
        String mensaje = "123456";
        System.out.println("Mensaje = " + mensaje);    
        System.out.println("MD5 = " + StringMD.getStringMessageDigest(mensaje, StringMD.MD5));  
    }

}
