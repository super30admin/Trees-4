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
    private List <TreeNode> path1;
    private List <TreeNode> path2;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int i = 0;
        int j = 0;
        
        backtrack(root, p, q, new ArrayList<>());
        
        int n = path1.size();
        int m = path2.size();
        
        while(i < n || j < m){
            if(path1.get(i) == path2.get(j)){
                i++; j ++;
            }
            else{
                return path1.get(i-1);
            }
        }
        return null;
    }
    
    
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        // base 
        if(root == null) return;
        
        // logic
        
        path.add(root);
        if(root == p){
            path1 = new ArrayList<>(path);
            path1.add(root);
        }
        if(root == q){
            path2 = new ArrayList<>(path);
            path2.add(root);
        }
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        // backtrack
        path.remove(path.size() - 1);
        
    }
    
}