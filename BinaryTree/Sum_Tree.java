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
    
    public static int sumTree(Node root){
        if(root == null) return 0;
        
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        
        root.data = root.data + left + right;
        return root.data;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] preorder = {
    1,
    2,
    4,
    8, -1, -1,
    9, -1, -1,
    5,
    10, -1, -1,
    -1,
    3,
    6, -1, -1,
    7,
    11, -1, -1,
    -1
};

        Node root = buildTree(preorder);

        System.out.println("Preorder traversal:");
        printPreorder(root);     
        System.out.println();
        System.out.println(sumTree(root));
        printPreorder(root);
        
        
    }
}