package BaekJoon.B_11060;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/09/16
 */
public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int len;
    private static int[] maze;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        List<Integer> list
                = Arrays.stream(dp)
                        .filter((el) -> el == -1)
                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list.size());

    }

    private static void input() throws IOException {
        len = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        maze = new int[len];
        dp = new int[len];
        maze = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.fill(dp, -1);
    }

    private static void solution() {
        for(int i = 0; i < len; i++) {
            for(int j = 1 ; j < maze[i] ; j++){
                if(i+j < len){
                    if(dp[i + j] == -1) {
                        dp[i + j] = dp[i] + 1;
                    }else {
                        dp[i + j] = Math.min(dp[i+j], dp[i] + 1);
                    }
                }
            }
        }
    }
}
