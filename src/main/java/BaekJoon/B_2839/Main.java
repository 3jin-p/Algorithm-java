package BaekJoon.B_2839;

import java.util.Scanner;
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int TOTAL;
    private static final int BIG_WEIGHT = 5, SMALL_WEIGHT = 3;
    private static int dp = -1;

    public static void main(String[] args) {
        // input
        TOTAL = sc.nextInt();
        // output
        calcul(TOTAL);
    }

    public static void calcul(int n) {
        int numOfBigWeight = n / BIG_WEIGHT;
        if(n % BIG_WEIGHT != 0) {
            while (numOfBigWeight >= 0) {
                int remains = n - BIG_WEIGHT * numOfBigWeight;
                if(remains % SMALL_WEIGHT == 0) {
                    dp = numOfBigWeight + (remains / SMALL_WEIGHT > 1 ? remains/SMALL_WEIGHT : 1);
                    break;
                }
                numOfBigWeight--;
            }
        }else {
            dp = numOfBigWeight;
        }


        System.out.println(dp);
    }

}
