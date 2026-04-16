import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Main {

    // Index tracker for preorder array
    static int index = 0;

    // Build tree from preorder array (-1 means null node)
    public static Node buildTree(int[] preorder) {
        int value = preorder[index++];
        
        if (value == -1) {
            return null;
        }

        Node newNode = new Node(value);
        newNode.left = buildTree(preorder);
        newNode.right = buildTree(preorder);

        return newNode;
    }

    // Preorder traversal: Root -> Left -> Right
    public static void printPreorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    
    public static void levelTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() != 0){
            Node node = q.poll();
            System.out.print(node.data+" ");
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] preorder = {
    1,
    2,
    3,
    4,
    -1, -1,
    -1,
    -1,
    -1
};

        Node root = buildTree(preorder);

        System.out.println("Preorder traversal:");
        printPreorder(root);
        System.out.println();
        levelTraversal(root);
        
    }
}