package kakao.n2018.캐시;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 2. 6.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"j", "j", "k", "t", "t","j"}));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            String lowerCase = city.toLowerCase();
            if (cache.contains(lowerCase)) {
                answer += 1;
                cache.remove(lowerCase);
            } else {
                answer += 5;
            }

            cache.offer(lowerCase);
            if (cache.size() > cacheSize) {
                cache.poll();
            }
        }
        return answer;
    }
}
