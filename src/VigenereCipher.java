import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plain text: ");
        String plainText = sc.nextLine();

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        String cipherText = encrypt(plainText, key);
        System.out.println("Cipher text: " + cipherText);

        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted text: " + decryptedText);
    }

    public static String encrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0, j = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);

            if (c >= 'a' && c <= 'z') {
                cipherText.append((char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a'));
                j = ++j % key.length();
            } else if (c >= 'A' && c <= 'Z') {
                cipherText.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
                j = ++j % key.length();
            } else {
                cipherText.append(c);
            }
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0, j = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);

            if (c >= 'a' && c <= 'z') {
                plainText.append((char) ((c - key.charAt(j) + 26) % 26 + 'a'));
                j = ++j % key.length();
            } else if (c >= 'A' && c <= 'Z') {
                plainText.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
                j = ++j % key.length();
            } else {
                plainText.append(c);
            }
        }

        return plainText.toString();
    }
}
