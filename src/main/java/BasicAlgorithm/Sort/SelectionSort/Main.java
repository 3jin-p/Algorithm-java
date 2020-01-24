package BasicAlgorithm.Sort.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unSortedArray = {5,1,4,9,3,2,7,6,8,10};
        System.out.println(Arrays.toString(selectionSort(unSortedArray)));
    }

    /*
    Selection Sort
    배열내 최소 값을 찾아 배열의 맨앞 인덱스의 인자와 자리를 바꿈
     */
    private static int[] selectionSort(int[] array) {

        int minIndex = 0;
        int size = array.length;
        for(int i = 0; i < size; i++){
            minIndex = getMinNumberIndex(i,array);
            swap(i,minIndex,array);
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
    /*
     배열 내 최솟값을 찾아 인덱스를 반환
     */
    private static int getMinNumberIndex(int startIndex, int[] array) {
        int minNum = array[startIndex];
        int returnIndex = startIndex;

        for(int i= startIndex; i < array.length; i++){
            if(minNum > array[i]){
                minNum = array[i];
                returnIndex = i;
            }
        }

        return returnIndex;
    }
}
