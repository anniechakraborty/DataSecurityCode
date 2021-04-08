import java.util.*;

public class LinearCongruence {
    protected int calcGcd(int r1, int r2) {
        int q = 0, r = 0;
        while (r2 > 0) {
            q = r1 / r2;
            r = r1 - q * r2;
            r1 = r2;
            r2 = r;
        }
        return r1;
    }

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
        System.out.println("-----Linear Congruence------");
        System.out.println("Equation form :\nax congruent to b (mod n)\n");
        System.out.println(
                "If equation is of the form ax + c congruent to b (mod n) \nthen subtract  c  from  b  and enter values as usual");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a : ");
        int a = sc.nextInt();
        System.out.println("\nEnter b : ");
        int b = sc.nextInt();
        System.out.println("\nEnter n : ");
        int n = sc.nextInt();
        sc.close();
        LinearCongruence obj = new LinearCongruence();
        int gcd = obj.calcGcd(a, n);
        System.out.println("GCD of " + a + " and " + n + " is : " + gcd);
        int quo = b / gcd;
        int rem = b % gcd;
        System.out.println(b + " divided by " + gcd + " is = quo : " + quo + " and rem : " + rem);
        if (rem != 0) {
            System.out.println("Equation is invalid!");
        } else {
            System.out.println("There are " + gcd + " number of solutions for x");
            int sol_x[] = new int[gcd];
            System.out.println("Calculating first solution of x \n\n");
            a = a / gcd;
            b = b / gcd;
            n = n / gcd;
            int inverseOfA = obj.multiplicativeInverse(n, a);
            System.out.println("Multiplicative Inverse of " + a + " is : " + inverseOfA);
            if (inverseOfA != -999) {
                System.out.println(
                        "Multiplying both a and b with inverse of a. \nNow inverse of a * a is 1. But b is - ");
                System.out.print(b);
                b = b * inverseOfA;
                System.out.println(" * " + inverseOfA + " = " + b);
                sol_x[0] = b % n;
                System.out.println("First solution x0 : " + sol_x[0]);
                // The general solutions
                for (int k = 1, i = 1; k <= gcd - 1; k++, i++) {
                    sol_x[i] = sol_x[0] + k * n; // since n / gcd is already calculated
                }
                System.out.println("All the solutions of x : " + Arrays.toString(sol_x));
            }
        }
    }
}
