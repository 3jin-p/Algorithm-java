package BaekJoon.B_1712;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();


        System.out.println(calcul(a, b ,c));
    }

    private static long calcul(long a, long b, long c) {
        long n = -1;
        if((c-b) > 0) {
            n = (a / (c-b)) + 1;
        }

        return n;
    }
}
