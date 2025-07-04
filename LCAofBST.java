//Iterative Time complexity : O(h)
//Iterative space complexity : O(1)
//Recursive TC : O(h)
//Recursive SC : O(h)
class Solution {
    //Iterative code:
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr!=null){
            if(p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            }
            else if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            }
            else{
                return curr;
            }
        }
        return null;
    }


    //Recursion code
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     //base case
    //     if(root == null){
    //         return null;
    //     }
    //     //logic : use BST property 
    //     if(p.val < root.val && q.val < root.val){
    //         return lowestCommonAncestor(root.left , p , q);
    //     }
    //     else if(p.val > root.val && q.val > root.val){
    //         return lowestCommonAncestor(root.right , p , q);
    //     }
    //     else{
    //         return root;
    //     }
        
    // }
}