package BasicAlgorithm.Graph.BinaryTree;

class BinaryTree {
    private Node rootNode;

    Node makeBinaryTree(Object data, Node left, Node right) {
        return new Node(data, left, right);
    }
    /*
    중위 순회
     */
    void preOrder(Node root){
        if(root != null){
            System.out.print(root.getData());
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    /*
   후위 순회
    */
    void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.getData());
            inOrder(root.right);
        }
    }
    /*
    후위순회
     */
    void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.getData());
        }
    }


}
