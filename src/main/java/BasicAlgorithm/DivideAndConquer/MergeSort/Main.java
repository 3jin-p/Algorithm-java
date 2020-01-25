package BasicAlgorithm.DivideAndConquer.MergeSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unSortedArray = {5,9,4,1,3,2,7,6,8,10};
        mergeSort(unSortedArray, 0 , unSortedArray.length - 1);
        System.out.println(Arrays.toString(unSortedArray));
    }


    private static void mergeSort(int[] array,int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int arr[], int low, int mid, int high) {
        System.out.println("merge");
        int i = low;
        int j = mid+1;
        int k = low;
        int[] temp = new int[arr.length];

        while(i<=mid && j<=high) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
            System.out.println(Arrays.toString(temp));
        }

        while(i<=mid){
            temp[k++] = arr[i++];
            System.out.println(Arrays.toString(temp));
        }

        while(j<=high){
            temp[k++] = arr[j++];
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("End");
        for(int index=low; index<k; index++){
            arr[index] = temp[index];
        }

    }

}
