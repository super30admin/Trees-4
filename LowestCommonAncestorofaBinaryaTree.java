//Approach - 1 : Recursive 
//Time Complexity : O(h) // logarithemic
//Space Complexity : O(h) // Stack 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //BST all nodes are left is less than root
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        //BST all nodes are left is greater than root
        else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        //if one node is on left and other on right, then LCA is root itself
        else return root;
    }
}

//Approach - 2 : Iterative by using while loop, no extra space bcz we are not using recursion
//Time Complexity : O(h) // logarithemic
//Space Complexity : 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        while(true){
        //BST all nodes are left is less than root
        if(root.val < p.val && root.val < q.val) root =  root.right;
        //BST all nodes are left is greater than root
        else if(root.val > p.val && root.val > q.val) root = root.left;
        //if one node is on left and other on right, then LCA is root itself
        else return root;
        }
   }

}
