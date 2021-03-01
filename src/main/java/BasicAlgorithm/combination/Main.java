package BasicAlgorithm.combination;

import java.util.Arrays;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2021/02/17
 */
public class Main {
    public static void main(String[] args) {

    }

    static void combinamtion(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            return;
        } else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                combinamtion(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
