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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        int[] postIdx={postorder.length-1};
        return recursion(inorder,postorder,0,postorder.length-1,map,postIdx);
    }
    public TreeNode recursion(int[] inorder, int[] postorder, int left,int right,Map<Integer,Integer> map,int[] postIdx) {
        if (left>right) return null;
        int rootval=postorder[postIdx[0]--];
        TreeNode root=new TreeNode(rootval);
        root.right=recursion(inorder,postorder,map.get(rootval)+1,right,map,postIdx);
        root.left=recursion(inorder,postorder,left,map.get(rootval)-1,map,postIdx);
        return root;
    }
}
