package Programmers.등굣길;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 2. 5.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(4,3, new int[][]{{2,2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[m+1][n+1];
        for (int[] puddle : puddles) {
            graph[puddle[0]][puddle[1]] = -1;
        }
        graph[1][1] = 1;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == -1){
                    continue;
                }

                graph[i][j] =  (Math.max(graph[i - 1][j], 0) % 1000000007) +  (Math.max(graph[i][j - 1], 0) % 1000000007);
            }
        }

        return graph[m][n] % 1000000007;
    }
}
