package BaekJoon.B_1009;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 입력처리
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int T = sc.nextInt(); // 테스트 케이스 의 수
        int a,b;

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            getLast(a, b);
        }
        bw.flush();
    }

    private static void getLast(int a, int b) throws IOException {
        int temp = a % 10;
        if(temp == 0){
            bw.write(10 + "\n");
            return;
        }

        for(int i = 0; i < b - 1; i++) {
            if( ((a % 10) * temp) != 0){
                temp = ((a % 10) * temp) % 10;
            }else{
                temp = 10;
            }
        }
        bw.write(temp + "\n");
    }
}
