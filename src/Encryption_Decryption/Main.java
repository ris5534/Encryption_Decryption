//package Encryption_Decryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.StringWriter;

public class Main {
    public static final String str = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plaint, int key) {
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

    public static String encrypt2(String plaint) {
        String cipher = "";
        plaint = plaint.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < plaint.length(); i++) {
            cipher = sb.append(plaint.charAt(i) - 'a' + 1).toString();
        }
        return cipher;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your String: ");
        String mag = br.readLine();
        System.out.println("\n");
        System.out.println("Encryption Pattern 1");
        System.out.println("Your Encrypted String is: " + encrypt(mag, 3));
        System.out.println("Your Decrypted is: " + decrypt(encrypt(mag, 3), 3));
        System.out.println("\n");
        System.out.println("Encryption Pattern 2");
        System.out.println("Your Encrypted String is: " + encrypt2(mag));
        System.out.println("The Decrypted String should match the original text however we couldn't " +
                "make the code work.\nYou can however see in the encryption that the letter is replaced " +
                "with it's number value where A=1 and Z=26");

    }
}
