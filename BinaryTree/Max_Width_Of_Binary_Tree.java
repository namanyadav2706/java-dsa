/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class TreeNode2{
    TreeNode node;
    int idx;
    public TreeNode2(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode2> q = new LinkedList<>();
        q.offerLast(new TreeNode2(root,0));
        int maxWidth = 0;

        while(q.size()>0){
            int currLevel = q.size();
            int start = q.peekFirst().idx;
            int end = q.peekLast().idx;

            maxWidth = Math.max(maxWidth, end - start + 1);

            for(int i=0;i<currLevel;i++){
                TreeNode2 curr = q.pollFirst();
                if(curr.node.left!=null){
                    q.offerLast(new TreeNode2(curr.node.left, 2*curr.idx + 1));
                }
                if(curr.node.right!=null){
                    q.offerLast(new TreeNode2(curr.node.right, 2*curr.idx + 2));
                }
            }
            
        }      
        return maxWidth;  
    }
}