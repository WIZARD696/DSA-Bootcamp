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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        helper(root,minHeap,k);

        //now we simply traverse till k
        int ans=0;
        for(int i=0;i<k;i++){
            ans=minHeap.poll();
        }
        return ans;
    }

    public void helper(TreeNode node,PriorityQueue<Integer> minHeap,int k){
        if(node==null){
            return;
        }
        //we use inorder Traversal
        helper(node.left,minHeap,k);

        minHeap.offer(node.val);

        helper(node.right,minHeap,k);
    }
}