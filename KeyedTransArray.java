import java.util.*;

public class KeyedTransArray {
    private void keyCalc() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter group / array size : ");
        int size = sc.nextInt();
        int keyEncrypt[] = new int[size], keyDecrypt[] = new int[size];
        System.out.println("Enter encryption array : ");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter key " + (i + 1) + " : ");
            keyEncrypt[i] = sc.nextInt() - 1;
        }
        System.out.println("Encryption key array : ");
        for (int i = 0; i < size; i++) {
            System.out.print((keyEncrypt[i] + 1) + "\t");
        }
        System.out.println();
        // Filling decryption key array
        for (int i = 0; i < size; i++) {
            int j = keyEncrypt[i];
            keyDecrypt[j] = i;
        }
        System.out.println("Decryption key array : ");
        for (int i = 0; i < size; i++) {
            System.out.print((keyDecrypt[i] + 1) + "\t");
        }
        System.out.println();
        sc.close();
    }

    public static void main(String[] args) {
        KeyedTransArray obj = new KeyedTransArray();
        obj.keyCalc();
    }
}
