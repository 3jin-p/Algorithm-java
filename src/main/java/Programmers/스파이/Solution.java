package Programmers.스파이;
import java.util.*;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/10/27
 */
class Solution {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.print(solution(clothes));
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> clothMap = sortCloth(clothes);
        Set<String> keySet = clothMap.keySet();
        Iterator<String> keyIter = keySet.iterator();
        int[] sizeArray = new int[keySet.size()];
        int index = 0;
        while (keyIter.hasNext()){
            String category = keyIter.next();
            sizeArray[index] = clothMap.get(category).size() + 1;
            index++;
        }

        for(int size : sizeArray) {
            answer *= size;
        }
        return answer - 1;
    }
    public static <T> HashMap<T, List<T>> sortCloth(T[][] clothes) {
        HashMap<T, List<T>> clothMap = new HashMap<>();

        for (T[] clothe : clothes) {
            T key = clothe[1];
            List<T> valueList = clothMap.computeIfAbsent(key, k -> new ArrayList<>());
            valueList.add(clothe[0]);
        }
        return clothMap;
    }
}