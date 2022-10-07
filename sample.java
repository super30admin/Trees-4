// Time Complexity : O(nodes)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

//  Kth Smallest Element in a BST

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
    int count;
    int result;
public int kthSmallest(TreeNode root, int k) {
    count = k;
    inorder(root);
    return result;
    
}

private void inorder(TreeNode root)
{
    if(root == null) return;
    
    //logic
    inorder(root.left);
    count--;
    if(count == 0)
        result = root.val;
    
    inorder(root.right);
}

}


// Time Complexity : O(height)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

//235. Lowest Common Ancestor of a Binary Search Tree


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val )
            return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p.val && root.val > q.val )
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}



// Time Complexity : O(height)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null) return null;
        else if(left!=null && right == null) return left;
        else if(left == null && right != null) return right;
        
        else return root;
        
    }
}