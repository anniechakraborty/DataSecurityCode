import java.util.*;

public class AutoKeySubstitutionCipher {
    private char arr[] = new char[26];
    private int keys[];

    private void initNumericEquivalent() {
        int j = 65;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) j;
            j++;
        }
    }

    private char getChar(int pos) {
        return arr[pos];
    }

    private int getPos(char ch) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                result = i;
            }
        }
        return result;
    }

    private String encryption(String plaintext, int key) {
        int length = plaintext.length();
        int numericEquivalent[] = new int[length], sum[] = new int[length];
        initNumericEquivalent();
        String cipher = "";
        // getting numeric equivalent
        for (int i = 0; i < length; i++) {
            numericEquivalent[i] = getPos(plaintext.charAt(i));
        }
        System.out.println("Numeric Equivalent : ");
        System.out.println(Arrays.toString(numericEquivalent));
        // generating the keys
        keys = new int[length];
        keys[0] = key;
        for (int i = 1; i < length; i++) {
            keys[i] = getPos(plaintext.charAt(i - 1));
        }
        System.out.println("The Keys : ");
        System.out.println(Arrays.toString(keys));
        // adding numeric equivalent to the keys
        for (int i = 0; i < length; i++) {
            sum[i] = (numericEquivalent[i] + keys[i]) % 26;
        }
        // getting the cipher text
        for (int i = 0; i < length; i++) {
            cipher += getChar(sum[i]);
        }
        return cipher;
    }

    private void decryption(String ciphertext) {
        int length = ciphertext.length();
        int numericEquivalent[] = new int[length], sum[] = new int[length];
        initNumericEquivalent();
        String plain = "";
        // getting numeric equivalent
        for (int i = 0; i < length; i++) {
            numericEquivalent[i] = getPos(ciphertext.charAt(i));
        }
        System.out.println("Numeric Equivalent : ");
        System.out.println(Arrays.toString(numericEquivalent));
        // generating the key inverses of the encryption keys
        for (int i = 0; i < length; i++) {
            if (keys[i] != 0) {
                keys[i] = 26 - keys[i];
            }
        }
        System.out.println("The Keys : ");
        System.out.println(Arrays.toString(keys));
        // adding numeric equivalent to the keys
        for (int i = 0; i < length; i++) {
            sum[i] = (numericEquivalent[i] + keys[i]) % 26;
        }
        // getting the cipher text
        for (int i = 0; i < length; i++) {
            plain += getChar(sum[i]);
        }
        System.out.println("The plain text is : " + plain);
    }

    public static void main(String[] args) {
        AutoKeySubstitutionCipher AK = new AutoKeySubstitutionCipher();
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        System.out.println("Enter the plain text : ");
        String plaintext = scanner.nextLine();
        plaintext = plaintext.toUpperCase();
        System.out.println("Enter the key : ");
        key = scanner.nextInt();
        String cipher = AK.encryption(plaintext, key);
        System.out.println("The Cipher is : " + cipher);
        System.out.println("Do you wish to carry out decryption ?");
        char response = scanner.next().charAt(0);
        if (response == 'Y' || response == 'y') {
            System.out.println("Do you wish to enter a cipher text ? ");
            response = scanner.next().charAt(0);
            if (response == 'Y' || response == 'y') {
                System.out.println("Enter the cipher text : ");
                cipher = scanner.nextLine();
                System.out.println("Do you wish to enter the key ? ");
                response = scanner.next().charAt(0);
                if (response == 'Y' || response == 'y') {
                    System.out.println("Enter the keys :");
                    for (int i = 0; i < cipher.length(); i++) {
                        AK.keys[i] = scanner.nextInt();
                    }
                }
            } else {
                System.out.println("The cipher text used is : " + cipher);
                System.out.println("The keys used are : " + Arrays.toString(AK.keys));
            }
            AK.decryption(cipher);
        }
        scanner.close();
    }

    // private void menu() {
    // System.out.println("----------Menu----------");
    // System.out.println("Press 0 to exit. ");
    // System.out.println("Press 1 to perform encryption. ");
    // System.out.println("Press 2 to perform decryption. ");
    // System.out.println("Enter choice : ");
    // }
}