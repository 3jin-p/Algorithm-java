package BaekJoon.B_9519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<String> list = new ArrayList();
        int tryTime = Integer.parseInt(br.readLine());
        String resultStr = br.readLine();

        for(int i = 0; i < resultStr.length(); i++) {
            list.add(resultStr.substring(i, i + 1));
        }
        
    }
}
