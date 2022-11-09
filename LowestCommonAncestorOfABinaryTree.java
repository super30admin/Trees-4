/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// //Time: O(n)
// //Space: O(n)
// class Solution {
//     List<TreeNode> pathQ;
//     List<TreeNode> pathP;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null)
//             return null;
//         pathQ = new ArrayList<>();
//         pathP = new ArrayList<>();
        
//         backtracking(root, p, q, new ArrayList<>());
        
//         for(int i = 0; i < pathP.size(); i++){
//             if(pathP.get(i) != pathQ.get(i))
//                 return pathP.get(i - 1);
//         }
//         return null;
//     }
    
//     private void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
//         if(root == null)
//             return;
//         path.add(root);
//         if(root == p){
//             pathP = new ArrayList<>(path);
//             pathP.add(p);
//         }
//         if(root == q){
//             pathQ = new ArrayList<>(path);
//             pathQ.add(q);
//         }
//         backtracking(root.left, p, q, path);
//         backtracking(root.right, p, q, path);
//         path.remove(path.size() - 1);
//     }
// }

//Time: O(n)
//Space: O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null)
            return null;
        
        else if(left != null && right == null)
            return left;
        
        else if(left == null && right != null)
            return right;
        
        else
            return root;
    }
}
