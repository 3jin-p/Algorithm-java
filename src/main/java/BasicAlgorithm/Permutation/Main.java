package BasicAlgorithm.Permutation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        perm(arr, 3, 0, new boolean[9], new int[9]);
    }

    public static void perm(int[] arr, int r, int depth, boolean[] visited, int[] results) {
        if(depth == r) {
            System.out.println(Arrays.toString(results));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            results[depth] = arr[i];
            perm(arr, r, depth + 1, visited, results);
            visited[i] = false;
        }
    }
}
