package BaekJoon.B_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/09/03
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int[][] tomatoBox;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int m,n;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        tomatoBox = new int[n][m];
        // init
        putTomatos(m, n);
        // run
        search(m, n);
    }

    // 토마토 박스 세팅
    private static void putTomatos(int m, int n) throws IOException {
        for(int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int[] line = new int[arr.length];
            for(int j = 0; j < arr.length; j++) {
                line[j] = Integer.parseInt(arr[j]);
            }

            tomatoBox[i] = line;
        }
    }


    private static void search(int m, int n) {
        Queue<Node> queue = new LinkedList<>();
        int day = 0;

        // 첫날 토마토가 있는 칸을 큐에 담아줌
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++ ){
                if (tomatoBox[i][j] == 1) {queue.add(new Node(i,j, day));}
            }
        }

        int result = 0;

        // BFS 순회하며 박스스테이터스를 변경
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result = node.day;

            validate_and_add2Queue(queue, node);
        }

        // 각 박스칸들을 체킹 후 반환값 결정
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++ ){
                if (tomatoBox[i][j] == 0) {
                    result = -1;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    private static void validate_and_add2Queue(Queue<Node> queue, Node node) {
        for(int i = 0; i < dx.length; i++){
            if(!(node.x + dx[i] < 0) && (node.x + dx[i] < n)
                    && !(node.y + dy[i] < 0) && (node.y + dy[i] < m)
                    &&  tomatoBox[node.x + dx[i]][node.y + dy[i]] == 0) {
                // 방문이 가능하고, 아직 익지않은 토마토가 있는 칸은 큐에 담음
                tomatoBox[node.x+dx[i]][node.y+dy[i]] = 1;
                queue.add(new Node(node.x + dx[i], node.y + dy[i], node.day + 1));
            }
        }
    }

    // 좌표값과 날짜 값을 지니는 큐에 담길 객체
    private static class Node {
        int x, y, day;
        public Node(int x, int y, int day) { this.x = x; this.y = y; this.day = day;}
    }
}
