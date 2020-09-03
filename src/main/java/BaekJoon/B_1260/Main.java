package BaekJoon.B_1260;

import java.io.*;
import java.util.*;

/**
 * <b>BFS / DFS 백준 1260</b>
 *
 * @author sejinpark
 * @since 2020/08/19
 */
public class Main {
    static final int MAX_VAL = 1001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int numOfSpots, numOfLines, startIndex;
    static StringTokenizer stringTokenizer;
    static int[][] graph = new int[MAX_VAL][MAX_VAL];
    static boolean[] visited = new boolean[MAX_VAL];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stringTokenizer = new StringTokenizer(br.readLine());

        numOfSpots = Integer.parseInt(stringTokenizer.nextToken());
        numOfLines = Integer.parseInt(stringTokenizer.nextToken());
        startIndex = Integer.parseInt(stringTokenizer.nextToken());
        // 인접행렬 세팅
        initGraph(graph, numOfLines);
        // 방문이력 배열 초기화
        Arrays.fill(visited, false);
        DFS(graph, startIndex);
        bw.newLine();
        // 방문이력 배열 초기화
        Arrays.fill(visited, false);
        BFS(graph, startIndex);
        bw.flush();
    }

    private static void initGraph(int[][] graph, int numOfLines) throws IOException {

        for(int i = 0; i < numOfLines; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }
    }

    private static void DFS(int[][] graph, int startIndex) throws IOException {
        if(!visited[startIndex]){
            bw.write(startIndex + " ");
            visited[startIndex] = true;
            int[] closeNodes = graph[startIndex];
            for(int i = 0; i < closeNodes.length; i++) {
                if(closeNodes[i] == 1){ DFS(graph, i);}
            }
        }
    }

    private static void BFS(int[][] graph, int startIndex) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        visited[startIndex] = true;
        bw.write(startIndex + " ");
        queue.add(graph[startIndex]);
        while (!queue.isEmpty()) {
            int[] closeNodes = queue.poll();
            for(int i = 0; i < closeNodes.length; i++){
                if(closeNodes[i] == 1 && !visited[i]) {
                    visited[i] = true;
                    bw.write(i + " ");
                    queue.add(graph[i]);
                }
            }
        }
    }

}
