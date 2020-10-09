//Kth smallest element in BST
// Time Complexity :0(n)
// Space Complexity :0(n) worst case if tree is skewed, or height
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
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
        if(root==null)
            return -1;
        TreeNode node= new TreeNode();
        node=root;
        Stack<TreeNode> s=new Stack<>();
        int count=0;
        while(!s.isEmpty() || node!=null )
        {
            if(node!=null)
            {
                s.push(node);
                node=node.left;
            }
            else
            {
                node=s.pop();
                count++;
                if(count==k)
                    return node.val;
                node=node.right;
            }
           
        }
         return -1;
    }
}


//Lowest common Ancestor of Binary search tree
// Time Complexity :0(logn)
// Space Complexity :0(n) worst case if tree is skewed, or height
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;    
    }
    
}

//Lowest common Ancestor of Binary tree
// Time Complexity :0(n)
// Space Complexity :0(max depth) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right !=null)
        {
            return root;
        }
       return left != null ? left : right;
        }
    }


