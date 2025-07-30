/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// //Path Finding Algorithm - maintaining path
// //recursion & Backtrack
// //Time = O(n), going over all the node
// //Space = O(h), h can become n
// class Solution {
//     List<TreeNode> pathP;
//     List<TreeNode> pathQ;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         helper(root, p, q, new ArrayList<>()); //backtrack function
//         for(int i=0; i < pathP.size(); i++){ //smaller
//             if(pathP.get(i)!=pathQ.get(i)){
//                 return pathP.get(i-1);
//             }
//         }
//         return null;
//     }
//     private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
//         //base
//         if(root == null) return;
//         if(pathP!=null && pathQ!=null) return;
//         //logic - preorder

//         //action
//         path.add(root);

//         if(root == p){
//             pathP = new ArrayList<>(path);
//             pathP.add(root);
//         }
//         if(root == q){
//             pathQ = new ArrayList<>(path);
//             pathQ.add(root);
//         }
        
//         //recurese
//         helper(root.left, p, q, path);
//         helper(root.right, p, q, path);

//         //backtrack
//         path.remove(path.size()-1);
//     }
// }



//recursion: no need to maintain a path or backtrack
//Time = O(n), in worst case
//Space = O(h), h can become n
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null | root ==p || root==q) return root;
       TreeNode left = lowestCommonAncestor(root.left,p,q);
       TreeNode right = lowestCommonAncestor(root.right,p,q);
       if(left==null && right==null) return null;
       else if(left!=null && right==null) return left;
       else if(left==null && right!=null) return right;
       else return root; //else if(left!=null && right!=null)
    }
}