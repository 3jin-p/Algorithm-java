package BaekJoon.B_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/09/23
 */
public class Main {
    static int size, count;
    static int[][] graph;
    static int[][] visited;
    static List<Integer> street = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        search();
    }

    public static void input() throws IOException {
        size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        visited = new int[size][size];
        for(int i = 0; i < size; i++) {
            String[] line = br.readLine().split("");
            graph[i] =
                    Arrays.stream(line)
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
    }

    public static void search() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                if(visited[i][j] != 1 && graph[i][j] != 0) {
                    street.add(0);
                    dfs(new Location(i, j));
                    count++;
                }
            }
        }
        System.out.println(street.size());
        street.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

    }

    public static void dfs(Location curr) {
        if(visited[curr.x][curr.y] != 1) {
            visited[curr.x][curr.y] = 1;
            if(graph[curr.x][curr.y] != 0){
                street.set(count,street.get(count) + 1);
                if (curr.x + 1 < size) {
                    dfs(new Location(curr.x + 1, curr.y));
                }
                if (curr.x - 1 > -1) {
                    dfs(new Location(curr.x - 1, curr.y));
                }
                if (curr.y + 1 < size) {
                    dfs(new Location(curr.x, curr.y + 1));
                }
                if (curr.y - 1 > -1) {
                    dfs(new Location(curr.x, curr.y - 1));
                }
            }
        }
    }


    static class Location {
        int x, y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
