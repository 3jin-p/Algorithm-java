package BaekJoon.B_2252;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A,B;
        int[] degree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();

        Queue<Integer> queue = new LinkedList();

        for(int i=0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            degree[B]++;
        }

        for(int i=1; i <= N; i++) {
            if(degree[i]==0) {    //degree가 0이면 큐에 넣는다.
                queue.add(i);
                degree[i]=-1;
            }
        }

        for(int i=0; i < N; i++) {
            if (!queue.isEmpty()) {
                int x = queue.poll(); 
                bw.write(x + " ");        //출력

                for (int j = 0; j < graph.get(x).size(); j++) {    //큐에서 뺀 x의 인접리스트
                    degree[graph.get(x).get(j)]--;        //리스트에 있는 데이터들의 degree를 1씩 감소

                    if (degree[graph.get(x).get(j)] == 0) {    //degree가 0 이라면
                        queue.add(graph.get(x).get(j));    //큐에 추가
                        degree[graph.get(x).get(j)] = -1;
                    }
                }
            } else {
                break;
            }
        }

        bw.flush();
    }


}
