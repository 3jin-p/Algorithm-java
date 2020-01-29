package BaekJoon.B_1010;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int r = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(cal(r,n));
        }
    }

    public static BigInteger cal(int r, int n) {

        BigInteger result = new BigInteger("1");
        int temp = r;

        while(r > 0) {
            break;
        }

        for( ; r > 0; r--) {
            result = result.multiply(BigInteger.valueOf(n));
            --n;
        }
        for( ; temp > 0; temp--) {
            result = result.divide(BigInteger.valueOf(temp));
        }

        return result;
    }
}
