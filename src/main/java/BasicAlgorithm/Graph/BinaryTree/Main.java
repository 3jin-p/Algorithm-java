package BasicAlgorithm.Graph.BinaryTree;

public class Main {
    public static void main(String[] args) {
        // 트리 생성
        BinaryTree b_tree = new BinaryTree();

        Node n7 = b_tree.makeBinaryTree("D", null, null);
        Node n6 = b_tree.makeBinaryTree("C", null, null);
        Node n5 = b_tree.makeBinaryTree("B", null, null);
        Node n4 = b_tree.makeBinaryTree("A", null, null);
        Node n3 = b_tree.makeBinaryTree("2", n6, n7);
        Node n2 = b_tree.makeBinaryTree("1", n4, n5);
        Node n1 = b_tree.makeBinaryTree("*", n2, n3);
        //==

        // root 부터 전위순회
        System.out.print("preorder : ");
        b_tree.preOrder(n1);

        // root 부터 중위순회
        System.out.print("inorder : ");
        b_tree.inOrder(n1);

        // root 부터 후위순회
        System.out.print("postorder : ");
        b_tree.postOrder(n1);



    }
}
