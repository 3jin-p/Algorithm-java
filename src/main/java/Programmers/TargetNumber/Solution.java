package Programmers.TargetNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/10/12
 */
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers;
    static int target;
    static BinaryTree binaryTree_P = new BinaryTree();
    static BinaryTree binaryTree_M = new BinaryTree();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        init();
        System.out.print(
                solution(numbers, target)
        );
    }

    // setting variables
    public static void init() throws IOException {
        String[] strNumbers = br.readLine().split(" ");
        numbers = new int[strNumbers.length];
        for(int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }
        target = Integer.parseInt(br.readLine());
    }

    public static void settingGraph(Node before, int i) {
        if(i >= numbers.length) {return;}
        Node plusNode = new Node();
        plusNode.value = numbers[i];
        Node minusNode = new Node();
        minusNode.value = -numbers[i];
        if(i == 0){
            binaryTree_P.root = plusNode;
            settingGraph(plusNode, ++i);
            binaryTree_M.root = minusNode;
            settingGraph(minusNode, i);
        }else {
           before.left = plusNode;
           before.right = minusNode;
           settingGraph(plusNode, ++i);
           settingGraph(minusNode, i);
        }
    }

    public static int solution(int[] numbers, int target) {
        settingGraph(null, 0);
        DFS(binaryTree_M.root, 0);
        DFS(binaryTree_P.root, 0);
        return ans;
    }

    public static void DFS(Node node, int result) {
        int val = result + node.value;
        if(node.left == null || node.right == null) {
            if(val == target){
                ans += 1;
            }
        }else {
            DFS(node.left, val);
            DFS(node.right, val);
        }
    }


    static class Node {
        protected Node left, right;
        private int value;
    }

    static class BinaryTree {
        private Node root;
    }
}