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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();// we use linkedlist as reference here
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {//if reverse is false we simply do simple breadth first search
                    TreeNode node = queue.pollFirst();
                    current.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                } else {//else we reverse the order by using Deque -->which is a  doubly inserting and deleting queue
                    TreeNode node = queue.pollLast();
                    current.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            reverse = !reverse;//this will change the reverse value from true false and vice versa each iteration
            result.add(current);
        }

        return result;
    }
}
