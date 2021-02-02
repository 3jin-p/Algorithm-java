package Programmers.N으로표현;
import java.util.*;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 2. 2.
 */
public class Solution {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }

    public static int solution(int N, int number) {
        if(N == number) {return 1;}
        Set<Integer>[] dp = new Set[8];
        for(int n = 0; n < 8; n++) {
            dp[n] = new HashSet<>();
            dp[n].add(Integer.valueOf(new String(new char[n + 1]).replace("\0", String.valueOf(N))));
        }

        for(int i = 1; i < 8; i++) {
            for(int j = 0; j < i; j++){
                for (int a : dp[j]) {
                    for (int b : dp[i - j - 1]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if(b > 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            if(dp[i].contains(number)){
                return i + 1;
            }
        }
        return -1;
    }
}
