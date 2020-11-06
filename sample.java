// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//To find the ancestor of nodes p and q.Check if p and q lie on left or right and return the ancestor
//p or q could also be ancestor depending upon the level 
//if p and q lie on either side then ancestor would be root
// Time Complexity :O(N)
// Space Complexity :O(N)
//Lowest Common Ancestor of a Binary Search Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root node
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
            }
        else{
            return root;
        
            
        }
    }
}
//Lowest Common Ancestor of a Binary Tree
//traverse the tree and check at each node if it's equivalent to p and q.
//case a) reach null
//case b) reach root
//else node is betwen root and leaf 

// Time Complexity :O(N)
// Space Complexity :O(N)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p==root || q== root) return root;

        //traverse each half of tree
        TreeNode left  = lowestCommonAncestor(root.left ,p ,q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);
        
        if(left != null && right != null) return root ;
        
        return left!=null ? left : right;
    }
}

