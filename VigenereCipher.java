import java.util.*;

public class VigenereCipher {
    protected char arr[] = new char[26];

    protected void initNumericEquivalent() {
        int j = 65;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) j;
            j++;
        }
    }

    protected char getChar(int pos) {
        return arr[pos];
    }

    protected int getPos(char ch) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                result = i;
            }
        }
        return result;
    }

    String encrypt(String plainText, String key) {
        String cipher = "";
        initNumericEquivalent();

        // Making the key of the same length as the plain text by repeatedly appending
        String keytext = "";
        int j = 0;
        for (int i = 0; i < plainText.length(); i++) {
            if (j == key.length()) {
                j = 0;
            }
            keytext += key.charAt(j);
            j++;
        }
        System.out.println();
        plainText = plainText.toUpperCase();
        keytext = keytext.toUpperCase();

        System.out.println("The Plain text is : " + plainText);
        System.out.println("The Key phrase is : " + keytext);

        for (int i = 0; i < plainText.length(); i++) {
            int numEq_PT = getPos(plainText.charAt(i));
            int numEq_Key = getPos(keytext.charAt(i));
            int sum = (numEq_Key + numEq_PT) % 26;
            cipher += getChar(sum);
        }
        return cipher;
    }

    public static void main(String[] args) {
        VigenereCipher vig = new VigenereCipher();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text : ");
        String text = sc.next();
        System.out.println("Enter the key : ");
        String key = sc.next();
        sc.close();
        String cipher = vig.encrypt(text, key);
        System.out.println("The Cipher text is : " + cipher);
    }
}
