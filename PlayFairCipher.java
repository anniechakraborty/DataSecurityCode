import java.util.*;

public class PlayFairCipher {
    private char keyMatrix[][] = new char[5][5];

    private boolean elementInMatrix(char ch) {
        int i, j;
        boolean flag = false;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == ch) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    protected void displayKeyMatrix() {
        int i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(keyMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void initKeyMatrix(String keyword) {
        int k = 0, i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (k < keyword.length()) {
                    if (keyword.charAt(k) == ' ') {
                        if (elementInMatrix(keyword.charAt(k)) != true) {
                            keyMatrix[i][j] = keyword.charAt(k + 1);
                        }
                        k += 2;
                    } else {
                        if (elementInMatrix(keyword.charAt(k)) != true) {
                            keyMatrix[i][j] = keyword.charAt(k);
                        }
                        k++;
                    }
                }
            }
        }
    }

    private void encryption(String plainText, String keyword) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plainText, keyword;
        System.out.println("Enter the plain text : ");
        plainText = scanner.nextLine().toLowerCase();
        System.out.println("Enter the keyword : ");
        keyword = scanner.nextLine().toUpperCase();
        PlayFairCipher PF = new PlayFairCipher();
        PF.initKeyMatrix(keyword);
        PF.displayKeyMatrix();
        // PF.encryption(plainText, keyword);
        scanner.close();
    }
}
