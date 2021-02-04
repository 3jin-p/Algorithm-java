package Programmers.P124나라의숫자;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 2. 4.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }

    public static String solution(int n) {
        String answer = "";
        String[] cache = new String[]{"4" , "1" , "2"};
        while (n > 0) {
            answer = cache[n % 3] + answer;
            n /= 3;
            if(n % 3 == 0) n--;
        }
        return answer;
    }

}
