package BasicAlgorithm.Sort.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unSortedArray = {5,1,4,9,3,2,7,6,8,10};
        System.out.println(Arrays.toString(bubbleSort(unSortedArray)));
    }

    /*
    버블 정렬은 붙어있는 두 원자 간의 크기를 비교하여
    서로 자리를 바꿔주며 정렬하는 기법이다.
     */
    private static int[]  bubbleSort(int[] array) {

            for (int i = 0; i < array.length; i++) {
                for (int j = i+1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        swap(i, j, array);
                    }
                }
            }

        return array;
    }

    /*
    두 인자들의 인덱스 교환
     */
    private static int[] swap(int index_1, int index_2, int[] array) {
        int temp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = temp;

        return array;
    }
}
