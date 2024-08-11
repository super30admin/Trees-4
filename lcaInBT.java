// TC-O(h), sc-O(h)
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
    List<TreeNode> pPath;
    List<TreeNode> qPath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root,p,q,new ArrayList<>());
        for(int i=0;i<pPath.size();i++){
            if(pPath.get(i)!=qPath.get(i)){
                return pPath.get(i-1);
            }
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path){
        // base
        if(root==null) return;
        // logic
        // action
        path.add(root);
        if(root.val==p.val){
           pPath = new ArrayList<>(path);
           pPath.add(p); 
        }
        if(root.val==q.val){
           qPath = new ArrayList<>(path);
           qPath.add(q); 
        }
        
        // recurse
        backtrack(root.left,p,q,path);
        backtrack(root.right,p,q,path);
        // bactrack
        path.remove(path.size()-1);
    }
}