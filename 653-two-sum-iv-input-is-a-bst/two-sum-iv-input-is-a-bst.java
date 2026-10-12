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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        return helper(root,k,set);
    }

    private boolean helper(TreeNode node,int k,Set<Integer> set){
        if(node==null){
            return false;
        }

        if(set.contains(k-node.val)){//similar to two sum 1 but we simply use trees and hashmap concepts here
            return true;
        }

        set.add(node.val);
        return helper(node.left,k,set)||helper(node.right,k,set);
    }
}