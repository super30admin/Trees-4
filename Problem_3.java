/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// check if present on left or right and return the node if present else null
// Your code here along with comments explaining your approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // null
        if( root == null || p == root || q == root ) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if( left == null && right == null){
            return null;
        }else if( left == null && right != null){
            return right;
        }else if( left != null && right == null){
            return left;
        }else{
            return root;
        }
    }
}

// // Time Complexity : O(n)
// // Space Complexity :O(2h)
// // Did this code successfully run on Leetcode : Yes
// // Three line explanation of solution in plain english
// // go to each node and check if the given p and q is there or not, if yes then add it twice
// // else do backtrack
// // Your code here along with comments explaining your approach
// class Solution {
//     List<TreeNode> pList;
//     List<TreeNode> qList;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         // null
//         if( root == null || p == root || q == root ) return root;
//         helper(root, p, q, new ArrayList<>());
//         for( int i = 0 ; i < pList.size(); i++){
//             if(pList.get(i) != qList.get(i)){
//                 return pList.get(i-1);
//             }
//         }
//         return null;
//     }
//     private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
//         //base
//         if(root == null ) return;
//         //logic
//         path.add(root);
//         if(root.val == p.val){
//             pList = new ArrayList<>(path);
//             pList.add(root);

//         }
//         if(root.val == q.val){
//             qList = new ArrayList<>(path);
//             qList.add(root);
//         }
//         // recurese
//         helper(root.left, p, q,path);
//         helper(root.right, p, q, path);
//         // backtrack
//         path.remove(path.size()-1);
//     }


// }