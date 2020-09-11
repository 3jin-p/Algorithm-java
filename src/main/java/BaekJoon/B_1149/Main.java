package BaekJoon.B_1149;

import java.io.IOException;
import java.util.Scanner;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/09/10
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] priceArr;

    public static void main(String[] args) throws IOException {
        // init
        init();
        paint();

    }

    public static void init() throws IOException {
        N = sc.nextInt();
        priceArr = new int[N][3];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++){
                priceArr[i][j] = sc.nextInt();
            }
        }
    }

    public static void paint() {
        for(int i = 1; i < N; i++) {
            // 빨강 스타트
            priceArr[i][0] += Math.min(priceArr[i-1][1], priceArr[i-1][2]);
            // 파랑 스타트
            priceArr[i][1] += Math.min(priceArr[i-1][0], priceArr[i-1][2]);
            // 초록 스타트
            priceArr[i][2] += Math.min(priceArr[i-1][0], priceArr[i-1][1]);

            // -> 각각 더할수있는 최솟값을 더해나감
        }

        System.out.println(
                Math.min(priceArr[N-1][0], Math.min(priceArr[N-1][1], priceArr[N-1][2]))
        );
    }

}
