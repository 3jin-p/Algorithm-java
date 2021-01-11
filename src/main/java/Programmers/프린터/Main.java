package Programmers.프린터;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 11.
 */
public class Main {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1,1,1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int order = 0;
        Queue<Page> printer = initPrinter(priorities);
        while (printer.iterator().hasNext()) {
            Page page = printer.poll();
            boolean isExistHigerPriority
                    = printer.stream().anyMatch((inPrinter) -> inPrinter.getPriority() > page.getPriority());

            if(isExistHigerPriority) {
                printer.add(page);
                continue;
            }
            order++;
            if(page.getFirstLocation() == location) {
                answer = order;
                break;
            }
        }
        return answer;
    }

    public static Queue<Page> initPrinter(int[] priorities) {
        Queue<Page> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            Page page = new Page(priorities[i], i);
            queue.add(page);
        }
        return queue;
    }

    static class Page {
        int priority;
        int firstLocation;

        public int getPriority() {
            return priority;
        }

        public int getFirstLocation() {
            return firstLocation;
        }

        Page(int priority, int firstLocation) {
            this.priority = priority;
            this.firstLocation = firstLocation;
        }

    }


}
