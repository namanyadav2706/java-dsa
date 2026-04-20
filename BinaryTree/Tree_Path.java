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
    
    public static void treePath(Node root, String path){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            path = path + root.data;
            System.out.println(path);
            return;
        }
        
        path = path + root.data + " ";
        treePath(root.left, path);
        treePath(root.right, path);
        return;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] preorder = {
    10,
    5,
    2,
    -1, -1,
    7,
    6, -1, -1,
    8, -1, -1,
    15,
    12,
    11, -1, -1,
    -1,
    20,
    18, -1, -1,
    25, -1, -1
};

        Node root = buildTree(preorder);

        System.out.println("Preorder traversal:");
        printPreorder(root);     
        System.out.println();
        treePath(root, "");
        
    }
}