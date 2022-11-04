//Note - In Binary search tree so everything right to Root is greater than root and left side will be less than Root. 
//tc - O(h) - wors case travel 
//sc - recusrive stack- O(h)

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
       //base case
        if(root  == null) return root;
        
        //logic
        if(root.val <p.val  && root.val < q.val) //go right
        {
            return lowestCommonAncestor(root.left, p,q);
        }
        else if(root.val > p.val  && root.val > q.val) //go left
        {
            return lowestCommonAncestor(root.right, p,q);
        }else
            return root;
    }
   
}

//iterative approach
//Note - In Binary search tree so everything right to Root is greater than root and left side will be less than Root. 
//tc - O(h) - wors case travel 
//sc - recusrive stack- O(h)

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
       //base case
        if(root  == null) return root;
        
        while(true)
        {
            if(root.val > p.val && root.val > q.val)
            {
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val)
            {
                root = root.right;
            }else
            {
                return root;
            }
        }
    }
}