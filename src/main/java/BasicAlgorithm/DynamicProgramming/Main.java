package BasicAlgorithm.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        int[] saveFibo = new int[n + 1];
        saveFibo[0] = 0;
        saveFibo[1] = 1;

        for(int i=2; i <= n; i++){
            saveFibo[i]=saveFibo[i-2]+saveFibo[i-1];
        }
        System.out.println( Arrays.toString(saveFibo));
        return saveFibo[n];
    }

}
