// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        while(true){
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
			else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else{
                return root;
            }
        }
    }
} 