package Encryption_Decryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final String str = "abcdefghijklmnopqrstuvwxyz";

    public static String encryption(String plaint, int key) {
        plaint = plaint.toLowerCase();
        String cipher = "";
        for (int i = 0; i < plaint.length(); i++) {
            int charpose = str.indexOf(plaint.charAt(i));
            int keyval = (charpose + key) % 26;
            char replaceval = str.charAt(keyval);
            cipher = cipher + replaceval;
        }
        return cipher;
    }

    public static String encryption2(String plaint, int key) {
        plaint = plaint.toLowerCase();
        String cipher = "";
        for (int i = 0; i < plaint.length(); i++) {
            int charpose = str.indexOf(plaint.charAt(i));
            int keyval = (charpose + key) % 26;
            char replaceval = str.charAt(keyval);
            cipher = cipher + replaceval;
        }
        return cipher;
    }

    public static String decrypt(String cipher, int key) {
        cipher = cipher.toLowerCase();
        String palint = "";
        for (int i = 0; i < cipher.length(); i++) {
            int charpose = str.indexOf(cipher.charAt(i));
            int keyval = (charpose - key) % 26;
            if (keyval < 0) {
                keyval = str.length() + keyval;
            }
            char replaceval = str.charAt(keyval);
            palint = palint + replaceval;
        }
        return palint;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your String: ");
        String mag = br.readLine();
        System.out.println("\n");
        System.out.println("Encryption Pattern 1");
        System.out.println("Your Encrypted String is: " + encryption(mag, 3));
        System.out.println("Your Decrypted is: " + decrypt(encryption(mag, 3), 3));
        System.out.println("\n");
        System.out.println("Encryption Pattern 2");
        System.out.println("Your Encrypted String is: " + encryption2(mag, 7));
        System.out.println("Your Decrypted is: " + decrypt(encryption(mag, 7), 7));
    }
}