package BasicAlgorithm.Permutation;

import java.util.Arrays;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2021/02/17
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        boolean[] visited = new boolean[9];
        int[] output = new int[9];
        perm(arr,output, visited,0,5, 3);
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }
}
