package Programmers.기능개발;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/10/21
 */
public class Solution {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.print(Arrays.toString(solution(progresses, speeds)));
    }
    static ArrayList<Integer> deployArray = new ArrayList<>();

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressQueue
                = new LinkedList<>(
                        Arrays.stream(progresses).boxed().collect(Collectors.toList()));
        Queue<Integer> speedQueue
                = new LinkedList<>(
                Arrays.stream(speeds).boxed().collect(Collectors.toList()));

        dayAfter(progressQueue, speedQueue);

        return deployArray.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void dayAfter(Queue<Integer> progressQueue, Queue<Integer> speedQueue) {
        Queue<Integer> queue = new LinkedList<>();
        while (!progressQueue.isEmpty()) {
            int speed = speedQueue.poll();
            int progress = progressQueue.poll() + speed;
            queue.add(progress);
            speedQueue.add(speed);
        }
        int deployCount = 0;
        while (!queue.isEmpty()) {
            int progress = queue.peek();
            if(progress < 100) {
                break;
            }
            queue.poll();
            speedQueue.poll();
            deployCount++;
        }
        if(deployCount > 0){
            deployArray.add(deployCount);
        }
        if(!queue.isEmpty()) {
            dayAfter(queue, speedQueue);
        }
    }
}
