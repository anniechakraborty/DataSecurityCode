import java.util.*;

public class Straight_PBox_invertible_eg {
    private void checkInvertibility() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter group / array size : ");
        int size = sc.nextInt();
        int key[] = new int[size], keyInvert[] = new int[size];
        System.out.println("Enter transposition array : ");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter key " + (i + 1) + " : ");
            key[i] = sc.nextInt() - 1;
        }
        System.out.println("Transposition key array : ");
        for (int i = 0; i < size; i++) {
            System.out.print((key[i] + 1) + "\t");
        }
        System.out.println();
        int indexArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            indexArray[i] = i;
        }
        for (int i = 0; i < size; i++) {
            // int ele;
            // for (int j = 0; j < size; j++) {
            // ele =
            // }
            keyInvert[key[i]] = indexArray[i];
        }
        System.out.println("Inverted transposition key array : ");
        for (int i = 0; i < size; i++) {
            System.out.print((keyInvert[i] + 1) + "\t");
        }
        System.out.println();
        sc.close();
    }

    public static void main(String[] args) {
        Straight_PBox_invertible_eg obj = new Straight_PBox_invertible_eg();
        obj.checkInvertibility();
    }
}
