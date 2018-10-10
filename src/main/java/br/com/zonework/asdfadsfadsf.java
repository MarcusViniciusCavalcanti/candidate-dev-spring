package br.com.zonework;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class asdfadsfadsf {

    public static void main(String[] args) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(StandardCharsets.UTF_8.encode("123456789"));
            String generatedPassword = String.format("%032x", new BigInteger(1, md.digest()));

            System.out.println(generatedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
