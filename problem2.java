// Time Complexity : O(log(n)) - I reduce the search space by half each time
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I make sure p<q in terms of value and then all I need to do is find a node such that node's value is in between p and q -> this will be lowest ancestor. If I don't find it, I move left or right depending if node is larger or smaller respectively. 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        if(pVal>qVal) {
            int temp = pVal;
            pVal = qVal;
            qVal = temp;
        }
        while(root!=null){
            if(root.val>=pVal && root.val<=qVal) return root;
            if (root.val<pVal) root = root.right;
            else root = root.left;
        }
        return null;
    }
}