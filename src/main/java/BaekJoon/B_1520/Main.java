package BaekJoon.B_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/09/04
 */
public class Main {

    static int m, n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        // init
        initGraph(m,n);
        // Solution
        System.out.println(searchRoute(0, 0));
    }

    // 초기화
    public static void initGraph(int m, int n) throws IOException {
        graph = new int[m][n];
        visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            String[] array = br.readLine().split(" ");
            Arrays.fill(visited[i], -1);
            for(int j = 0; j < array.length; j++) {
                graph[i][j] = Integer.parseInt(array[j]);
            }
        }
    }

    // DFS + DP
    public static int searchRoute(int x, int y) {
        // 최종지점 도착시 1 리턴
        if(x == m - 1 && y == n - 1) {
            return 1;
        }
        // 최종 지점에 도착했던 루트가 아닌 경우
        if(visited[x][y] == -1) {
            visited[x][y] = 0;
            for(int i = 0; i < 4; i++) {
                // 다음 경로가 갈 수 있는 루트면
                if ((x+dx[i] >= 0 && x+dx[i] < m)
                        && (y+dy[i] >= 0  && y+dy[i] < n)
                        && graph[x][y] > graph[x+dx[i]][y+dy[i]]) {
                    // 다음 경로의 값을 더해줌(최종지점에 도착했다면 +1이 될 것)
                    visited[x][y] += searchRoute(x+dx[i], y+dy[i]);
                }
            }
        }
        //
        return visited[x][y];
    }

}
