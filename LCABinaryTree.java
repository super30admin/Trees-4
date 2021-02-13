/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
method1: brute force approach of building paths and adding to list.
traverse the list to find the last matching node. 
return node.

method2: 
recursion to find the lca. 

*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        
        //method1
        // List<TreeNode>path1 = new ArrayList<>();
        // List<TreeNode>path2 = new ArrayList<>();
        // backtrack(root,p,path1);
        // backtrack(root,q,path2);
        // for(int i = 0;i < path1.size();i++){
        //     if(path1.get(i)!=path2.get(i)){
        //         return path1.get(i-1);
        //     }
        // }
        
        //method 2
        if(root == null || root == p || root == q){
            return root;
        }
        
        //search p,q on the left of the current rootif found set left whichever node is found
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        
        if(left != null && right != null)return root;
        
       else if(left != null)return left;
        
       else  if(right != null) return right;
    
        else return null;    
    }
//     private void backtrack(TreeNode root, TreeNode node,List<TreeNode>path){
//         if(root == null)return ;
//         if(root == node){
//             path.add(root);
//             path.add(root);
//         }
//         path.add(root);
//         //recurse
//         backtrack(root.left,node,path);
//         //if(path.get(path.size()-1) == node)return;
        
//         backtrack(root.right,node,path);
//         if(path.get(path.size()-1) == node)return;
       
//         //backtrack
//         path.remove(path.size()-1);
//     }
    
}