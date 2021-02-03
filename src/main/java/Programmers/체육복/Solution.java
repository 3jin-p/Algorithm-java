package Programmers.체육복;

import java.util.*;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 2. 3.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{3,1}, new int[]{2,3}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> checkReserved = new HashSet<>();
        Set<Integer> checkLosted = new HashSet<>();

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    checkLosted.add(i);
                    checkReserved.add(j);
                }
            }
        }

        for(int i = 0; i < lost.length; i++) {
            if(checkLosted.contains(i)) {
                continue;
            }
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    if(checkReserved.contains(j)){
                        continue;
                    }
                    checkLosted.add(i);
                    checkReserved.add(j);
                    break;
                }
            }
        }

        return n - (lost.length - checkLosted.size());
    }
}
