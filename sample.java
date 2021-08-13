// Time Complexity : O(H)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


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
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result = 0;
        if(root == null) {
            return result;
        }
        
        count = 0;
        helper(root,k);
        
        return result;
    }
    
    private void helper(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        
        helper(root.left,k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        // System.out.println(root.val + ", " + count);
        helper(root.right,k);
    }
}


// Time Complexity : O(H)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     
        if(root == null) {
            return root;
        }
        while(true) {
            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}


// Time Complexity : O(H)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no



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
        if(root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            return left;
        } else if(right !=null) {
            return right;
        } else {
            return null;
        }
        
    }
}