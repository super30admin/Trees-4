import java.util.ArrayList;

// Time Complexity : O(n), to traverse all nodes
// Space Complexity : O(n) to maintain traversal
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class SmallestElementBSTSolution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k-1);
    }
    
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){ // get BST from min to max
        if (root == null){
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val); // add to array every time no more left children (leftmost of subtree)
        inorder(root.right, arr);
        return arr;
    }
}