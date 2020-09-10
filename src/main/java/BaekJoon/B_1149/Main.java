package BaekJoon.B_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/09/10
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] priceArr;
    static int bestPrice = 1000;

    public static void main(String[] args) throws IOException {
        // init
        init();
        for(int i = 0; i < N; i++){
            paint(0, i);
        }
        System.out.println(bestPrice);
    }

    public static void init() throws IOException {
        N = sc.nextInt();
        priceArr = new int[N][3];
        for(int i = 0; i < N; i++) {
            priceArr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    public static int paint() {

    }

}
