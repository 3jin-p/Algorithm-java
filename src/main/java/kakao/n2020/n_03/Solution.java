package kakao.n2020.n_03;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;
/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 13.
 */
public class Solution {
    public static void main(String[] args) {
        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock= {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(Arrays.deepToString(createKeySizeLagerLock(key.length, lock)));

    }
//    static boolean solution(int[][] key, int[][] lock) {
//        int m = key.length;
//        int n = lock.length;
//        int[][] largerLock = new int[m + n][m + n];
//
//    }

    static int[][] createKeySizeLagerLock(int keySize, int[][] lock) {
        int lockSize = lock.length;
        int fixedSize = 2 * keySize + lockSize;
        int[][] largerLock = new int[fixedSize][fixedSize];
        for(int i = keySize + 1; i < keySize + lockSize; i++) {
            for(int j = 0; j < lockSize; j++) {
                largerLock[i][j] = lock[i - keySize][j];
            }
        }
        return largerLock;
    }

    static int[][] spin90Angle(int[][] key) {
        int[][] spinned = new int[key.length][key.length];
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                spinned[j][i] = key[i][j];
            }
        }
        return spinned;
    }

}
