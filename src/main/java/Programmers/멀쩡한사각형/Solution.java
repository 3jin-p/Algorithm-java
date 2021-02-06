package Programmers.멀쩡한사각형;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 2. 6.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(100, 100, new int[]{10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> trucks = Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(LinkedList::new));

        for(int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        while (!queue.isEmpty()) {
            count++;
            sum -= queue.peek();
            queue.poll();
            if(!trucks.isEmpty() && sum + trucks.peek() <= weight) {
                sum += trucks.peek();
                queue.add(trucks.poll());
            }else if(!trucks.isEmpty()) {
                queue.add(0);
            }
        }

        return count;
    }

}
