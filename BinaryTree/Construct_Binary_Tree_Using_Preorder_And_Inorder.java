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
class Solution {
    int index = 0;
    public int search(int[] arr, int ele, int left, int right){
        int ans=0;
        for(int i=left;i<=right;i++){
            if(arr[i]==ele){
                ans = i;
                break;
            }
        }
        return ans;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if(left>right) return null;
        TreeNode root = new TreeNode(preorder[index]);

        int inIndex = search(inorder, preorder[index], left, right);
        index++;
        root.left = helper(preorder,inorder,left,inIndex-1);
        root.right = helper(preorder,inorder,inIndex+1,right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,inorder.length-1);
    }
}