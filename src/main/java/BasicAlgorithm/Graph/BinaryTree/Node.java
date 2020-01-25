package BasicAlgorithm.Graph.BinaryTree;

public class Node {
    // 노드의 값
    Object data;
    // 각 왼쪽 오른쪽 노드
    Node left;
    Node right;

    public Node(Object data,Node left,Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Object getData(){
        return this.data;
    }

}
