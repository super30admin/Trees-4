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
        // base
        if(root == p || root == q) return root;
        if(root == null) return null;
        // logic
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null && right!=null) return right;
        else if(right==null && left!=null) return left;
        else if(right==null && left==null) return null;
        else if(left!=null && right!=null) return root;
        return null;        
    }
}


// TC - O(n) -- as we may need to traverse all elements to get p or q- confirm once
// SC - O(h) -- h is height of tree = logn as we use path to store it - confirm once
// class Solution {
//     List<TreeNode> pathP;
//     List<TreeNode> pathQ;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         pathP = new ArrayList<>();
//         pathQ = new ArrayList<>();
//         helper(root,p,q, new ArrayList<>());
//         // To find the uncommon element from the 2 paths which we got
//         for(int i=0; i<pathP.size();i++){
//             if(pathP.get(i).val != pathQ.get(i).val) return pathP.get(i-1);
//         }
//         return null;
//     }
//     private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
//         // base
//         if(root == null) return;
//         // logic
//         path.add(root);
//         if(root == p){
//             pathP = new ArrayList<>(path);
//             pathP.add(root);
//         }
//         if(root == q){
//             pathQ = new ArrayList<>(path);
//             pathQ.add(root);
//         }
//         // Conditional Recursion
//         // if(pathQ.size()==0 || pathP.size()==0){
//         //     helper(root.left,p,q,path);
//         // }
//         // if(pathQ.size()==0 || pathP.size()==0){
//         //     helper(root.right,p,q,path);
//         // }
//         helper(root.left,p,q,path);
//         helper(root.right,p,q,path);
//         path.remove(root);
//     }
// }