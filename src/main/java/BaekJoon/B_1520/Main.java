package BaekJoon.B_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int numberOfRoute = 0;
    static Position savePoint;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());

        initGraph(m,n);
        searchRoute(new Position());
        System.out.println(numberOfRoute);
    }

    public static void initGraph(int m, int n) throws IOException {
        graph = new int[m][n];
        for(int i = 0; i < m; i++) {
            String[] array = br.readLine().split(" ");
            graph[i] = convertStrArray_toIntArray(array);
        }
    }

    public static int[] convertStrArray_toIntArray(String[] strArr) {
        int[] intArr = new int[n];
        for(int j = 0; j < strArr.length; j++) {
            intArr[j] = Integer.parseInt(strArr[j]);
        }
        return intArr;
    }

    public static void searchRoute(Position position) {
        Stack<Position> savePoints = new Stack<>();
        if(position.isEnd()) {
            numberOfRoute += 1;
        }
        graph[position.x][position.y]
    }

    static final int LEFT = 0, RIGHT = 1, TOP = 2, BOTTOM = 3;

    public static class Position {
        int x = 0, y = 0;
        boolean left = false, right = false, top = false, bottom = false;

        Position() {};
        Position(int x, int y) {
            this.x = x;
            this.y = y;
            if(x - 1 < 0) { left = true;}
            if(x + 1 > m) { right = true;}
            if(y - 1 < 0) { top = true;}
            if(y + 1 > n) { bottom = true;}
        }

        void getNext(int x, int y) {
            this.x += x;
            this.y += y;
        }
        void getAvailable() {

        }
        boolean isEnd() {
            return x == m - 1 && y == n - 1;
        }
    }
}
