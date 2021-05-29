import java.util.*;

public class KeyedTranspositionCipher {
    private void menu() {
        System.out.println("----------Menu----------");
        System.out.println("Press 0 to exit. ");
        System.out.println("Press 1 to perform encryption. ");
        System.out.println("Press 2 to perform decryption. ");
        System.out.println("Enter choice : ");
    }

    private void encrypt(String plainText, int key[]) {
        String cipher = "";
        int k = 0;
        for (int i = 0; i < plainText.length(); i += 1) {
            for (int j = 0; j < key.length; j++) {
                cipher += plainText.charAt(key[j] + k);
                k++;
            }
        }
        System.out.println("The cipher text is : " + cipher);
    }

    private void decrypt(String cipher, int key[]) {
        String plainText = "";
        for (int i = 0; i < cipher.length(); i++) {
            for (int j = 0; j < key.length; j++) {
                plainText += cipher.charAt(key[j]);
            }
        }
        System.out.println("The plain text is : " + plainText);
    }

    public static void main(String[] args) {
        KeyedTranspositionCipher obj = new KeyedTranspositionCipher();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter group / array size : ");
        int size = sc.nextInt();
        int keyEncrypt[] = new int[size], keyDecrypt[] = new int[size];
        System.out.println("Enter encryption array : ");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter key " + (i + 1) + " : ");
            keyEncrypt[i] = sc.nextInt() - 1;
        }
        System.out.println("Encryption key array : " + Arrays.toString(keyEncrypt));
        // Filling decryption key array
        for (int i = 0; i < size; i++) {
            int j = keyEncrypt[i];
            keyDecrypt[j] = i;
        }
        System.out.println("Decryption key array : " + Arrays.toString(keyDecrypt));
        obj.menu();
        int choice = sc.nextInt();
        switch (choice) {
        case 0:
            break;
        case 1:
            sc.nextLine();
            System.out.println("Enter plain text : (no spaces)");
            String text = sc.next().toUpperCase();
            // Adding dummy characters if text length isn't divisible by key array size
            if (text.length() % size != 0) {
                // number of dummy characters to be added
                int num_dum = text.length() % size;
            }
            obj.encrypt(text, keyEncrypt);
            break;
        case 2:
            sc.nextLine();
            System.out.println("Enter plain text : (no spaces)");
            String cipher = sc.next().toUpperCase();
            obj.decrypt(cipher, keyEncrypt);
            break;
        }

        sc.close();
    }
}
