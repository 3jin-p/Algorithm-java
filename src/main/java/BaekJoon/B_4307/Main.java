package BaekJoon.B_4307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));


        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int x = 1; x <= count; x++){
            st = new StringTokenizer(br.readLine());

            int lengthOfStick = Integer.parseInt(st.nextToken());
            int antNum = Integer.parseInt(st.nextToken());
            int[] locationOfAnts = new int[antNum];

            for(int i = 0; i < antNum; i++){
                locationOfAnts[i] = Integer.parseInt(br.readLine());
            }
            findWorstAndBestCase(locationOfAnts, lengthOfStick);
        }

    }

    private static void findWorstAndBestCase(int[] locationOfAnts, int lengthOfStick) {
        int[] minTimes = new int[locationOfAnts.length];
        int[] maxTimes = new int[locationOfAnts.length];

        for(int i = 0; i < locationOfAnts.length; i++){
            if((lengthOfStick - locationOfAnts[i]) > locationOfAnts[i]){
                minTimes[i] = locationOfAnts[i];
                maxTimes[i] = lengthOfStick - locationOfAnts[i];
            }else if( (lengthOfStick - locationOfAnts[i]) < locationOfAnts[i]){
                minTimes[i] = lengthOfStick - locationOfAnts[i];
                maxTimes[i] = locationOfAnts[i];
            }else {
                maxTimes[i] = locationOfAnts[i] = minTimes[i];
            }
        }
        System.out.println(getMinNumInArray(minTimes)+ " " +getMaxNumInArray(maxTimes));

    }

    private static int getMaxNumInArray(int[] array){
        int result = array[0];
        for (int i = 1; i < array.length; i++){
            if(result < array[i]){
                result = array[i];
            }
        }
        return result;
    }

    private static int getMinNumInArray(int[] array){
        int result = array[0];
        for (int i = 1; i < array.length; i++){
            if(result < array[i]){
                result = array[i];
            }
        }
        return result;
    }
}


