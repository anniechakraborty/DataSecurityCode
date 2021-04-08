import java.util.*;

public class AffineCipher {
    private void menu() {
        System.out.println("----------AFFINE CIPHER----------");
        System.out.println("Press 0 to exit. ");
        System.out.println("Press 1 to perform encryption. ");
        System.out.println("Press 2 to perform decryption. ");
        System.out.println("Enter choice : ");
    }

    private void encrypt(String plainText, int multKey, int addKey) {
        AutoKeySubstitutionCipher ob = new AutoKeySubstitutionCipher();
        ob.initNumericEquivalent();
        plainText = plainText.toUpperCase();
        System.out.println("CIPHER = (PT * K1 + K2) MOD 26");
        String cipher = "";
        System.out.println("CT char\tNE\tPT NE\tPT char");
        for (int i = 0; i < plainText.length(); i++) {
            System.out.print(plainText.charAt(i));
            int plaChar = ob.getPos(plainText.charAt(i));
            System.out.print("\t" + plaChar);
            int cipChar = (plaChar * multKey + addKey) % 26;
            System.out.print("\t" + cipChar);
            cipher += ob.getChar(cipChar);
            System.out.print("\t" + cipher);
            System.out.println();
        }
        System.out.println("The Cipher : " + cipher);
    }

    private void decrypt(String cipher, int multKey, int addKey) {
        AutoKeySubstitutionCipher ob = new AutoKeySubstitutionCipher();
        MultiplicativeSubstitutionCipher obj = new MultiplicativeSubstitutionCipher();
        ob.initNumericEquivalent();
        String plain = "";

        // Finding the multiplicative inverse of the key
        int multKeyInv = obj.multiplicativeInverse(26, multKey);
        System.out.println("The multiplicative inverse of " + multKey + " is : " + multKeyInv);
        System.out.println("CT char\tNE\tPT NE\tPT char");
        for (int i = 0; i < cipher.length(); i++) {
            System.out.print(cipher.charAt(i));
            int cipChar = ob.getPos(cipher.charAt(i));
            System.out.print("\t" + cipChar);
            int tempVal = (cipChar - addKey) * multKeyInv;
            if (tempVal < 0) {
                tempVal = tempVal + 26;
            }
            int plaChar = tempVal % 26;
            System.out.print("\t" + plaChar);
            plain += ob.getChar(plaChar);
            System.out.print("\t" + plain);
            System.out.println();
        }
        System.out.println("The Plain Text : " + plain);
    }

    public static void main(String[] args) {
        AffineCipher obj = new AffineCipher();
        Scanner sc = new Scanner(System.in);
        int key1, key2;
        System.out.println("Enter MULTIPLICATIVE key :");
        key1 = sc.nextInt();
        System.out.println("Enter ADDITIVE key :");
        key2 = sc.nextInt();
        obj.menu();
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
        case 0:
            break;
        case 1:
            System.out.println("Enter the plain text : ");
            String plainText = sc.nextLine();
            obj.encrypt(plainText, key1, key2);
            break;
        case 2:
            System.out.println("Enter the cipher text : ");
            String cipher = sc.nextLine();
            obj.decrypt(cipher, key1, key2);
            break;
        default:
            System.out.println("Wrong choice");
        }
        sc.close();
    }
}
