import java.util.*;

class ExtendedEuclidenAlgorithm {
    private int s, t;

    private int calcGCD(int r1, int r2) {
        int s1 = 1, s2 = 0, t1 = 0, t2 = 1, q = 0, r = 0;
        System.out.println("\nq \t r1 \t r2 \t r \t s1 \t s2 \t s \t t1 \t t2 \t t");
        while (r2 > 0) {
            System.out.println(q + " \t " + r1 + " \t " + r2 + " \t " + r + " \t " + s1 + " \t " + s2 + " \t " + s
                    + " \t " + t1 + " \t " + t2 + " \t " + t);
            q = r1 / r2;
            r = r1 - q * r2;
            r1 = r2;
            r2 = r;
            s = s1 - q * s2;
            s1 = s2;
            s2 = s;
            t = t1 - q * t2;
            t1 = t2;
            t2 = t;
        }
        s = s1;
        t = t1;
        return r1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExtendedEuclidenAlgorithm obj = new ExtendedEuclidenAlgorithm();
        System.out.println("\nEnter the first number : ");
        int num1 = sc.nextInt();
        System.out.println("\nEnter the second number : ");
        int num2 = sc.nextInt();
        sc.close();
        System.out.println("\nCalculating GCD(" + num1 + ", " + num2 + ") and the values of s and t ---");
        int gcd = obj.calcGCD(num1, num2);
        System.out.println("\nGCD of " + num1 + " and " + num2 + " is : " + gcd);
        System.out.println("\ns = " + obj.s + "\t t = " + obj.t);
        System.out.println(obj.s + " X " + num1 + " + " + obj.t + " X " + num2 + " = " + gcd);
    }
}