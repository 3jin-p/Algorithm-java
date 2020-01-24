package BasicAlgorithm.Sort.InsertSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unSortedArray = {5,9,4,1,3,2,7,6,8,10};
        System.out.println(Arrays.toString(insertSort(unSortedArray)));
    }

    private static int[] insertSort(int[] array){
        int key = 1;
        while (key < array.length){
            int temp = array[key];

            for(int i = key - 1; i >= 0 ; i--){
                if(array[i] < temp){
                    array[i+1] = temp;
                    break;
                }else if (array[i] > temp) {
                    array[i+1] = array[i];
                    if(i == 0){
                        array[0] = temp;
                    }
                }
            }
            key++;
        }


        return array;
    }
}
