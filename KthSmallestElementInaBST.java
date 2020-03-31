/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time complexity:O(n)
// Space complexity: 0(1)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;

        while(cursor != null) {
        	stack.push(cursor);
        	cursor = cursor.left;
        }

        while(!stack.isEmpty()) {
        	cursor = stack.pop();

        	k--;
        	if(k == 0) return cursor.val;

        	if(cursor.right != null) {
        		cursor = cursor.right;
        		while(cursor != null) {
        			stack.push(cursor);
        			cursor = cursor.left;
        		}
        	}
        }

        return 0;

    }
}

