import java.util.*;

public class MultiplicativeInverse {
    protected int multiplicativeInverse(int r1, int r2) {
        int t1 = 0, t2 = 1, q = 0, r = 0, t;
        int zn = r1;
        while (r2 > 0) {
            q = r1 / r2;
            r = r1 - q * r2;
            r1 = r2;
            r2 = r;
            t = t1 - q * t2;
            t1 = t2;
            t2 = t;
        }
        if (r1 == 1) {
            t = t1 > 0 ? t1 : zn + t1;
            return t;
        } else {
            return -999;
        }
    }

    public static void main(String[] args) {
        System.out.println("--------Calculating Multiplicative Inverse-------");
        Scanner sc = new Scanner(System.in);
        MultiplicativeInverse obj = new MultiplicativeInverse();
        System.out.println("\nEnter the first number (value of n) : ");
        int num1 = sc.nextInt();
        System.out.println("\nEnter the second number (whose inverse is to be calculated) : ");
        int num2 = sc.nextInt();
        sc.close();
        int inverse = obj.multiplicativeInverse(num1, num2);
        if (inverse == -999) {
            System.out.println("Inverse doesn't exist as gcd(" + num1 + ", " + num2 + ") != 1");
        } else {
            System.out.println("Inverse of " + num2 + " in Z" + num1 + " is : " + inverse);
        }
    }
}
