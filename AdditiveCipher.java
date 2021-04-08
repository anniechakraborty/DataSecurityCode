import java.util.*;

public class AdditiveCipher {
    private void menu() {
        System.out.println("----------Menu----------");
        System.out.println("Press 0 to exit. ");
        System.out.println("Press 1 to perform encryption. ");
        System.out.println("Press 2 to perform decryption. ");
        System.out.println("Enter choice : ");
    }

    private void encryption(String plainText, int key) {
        AutoKeySubstitutionCipher ob = new AutoKeySubstitutionCipher();
        ob.initNumericEquivalent();
        plainText = plainText.toUpperCase();
        String cipher = "";
        System.out.println("PT char\tNE\tCT NE\tCT char");
        for (int i = 0; i < plainText.length(); i++) {
            System.out.print(plainText.charAt(i));
            int plaChar = ob.getPos(plainText.charAt(i));
            System.out.print("\t" + plaChar);
            int cipChar = (plaChar + key) % 26;
            System.out.print("\t" + cipChar);
            cipher += ob.getChar(cipChar);
            System.out.print("\t" + cipher);
            System.out.println();
        }
        System.out.println("The Cipher : " + cipher);
    }

    private void decryption(String cipher, int key) {
        AutoKeySubstitutionCipher ob = new AutoKeySubstitutionCipher();
        ob.initNumericEquivalent();
        String plain = "";
        System.out.println("CT char\tNE\tPT NE\tPT char");
        for (int i = 0; i < cipher.length(); i++) {
            System.out.print(cipher.charAt(i));
            int cipChar = ob.getPos(cipher.charAt(i));
            System.out.print("\t" + cipChar);
            int temp = (cipChar - key);
            temp = temp < 0 ? 26 + temp : temp;
            int plaChar = temp % 26;
            System.out.print("\t" + plaChar);
            plain += ob.getChar(plaChar);
            System.out.print("\t" + plain);
            System.out.println();
        }
        System.out.println("The Plain Text : " + plain);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdditiveCipher obj = new AdditiveCipher();
        obj.menu();
        int choice = sc.nextInt(), key;
        sc.nextLine();
        switch (choice) {
        case 0:
            break;
        case 1:
            System.out.println("Enter the plain text : ");
            String plainText = sc.nextLine();
            System.out.println("Enter key :");
            key = sc.nextInt();
            obj.encryption(plainText, key);
            break;
        case 2:
            System.out.println("Enter the cipher text : ");
            String cipher = sc.nextLine();
            System.out.println("Enter the key used in encryption process : ");
            key = sc.nextInt();
            obj.decryption(cipher, key);
            break;
        default:
            System.out.println("Wrong choice");
        }
        sc.close();
    }
}
