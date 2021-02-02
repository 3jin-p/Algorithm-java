package BaekJoon.B_9095;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 2. 2.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] inputs = new int[T];

        for(int i = 0; i < T; i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }

        for (int input : inputs) {
            System.out.println(solution(input));
        }
    }

    public static int solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for(int i = 3; i < n; i++){
            arr[i] = arr[i - 1] +  arr[i - 2] + arr[i - 3];
        }
        return arr[n - 1];
    }
}
