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
    List<TreeNode> lpath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        lpath = new ArrayList<>();
        fpath(root,p,new ArrayList<>());
        List<TreeNode> pathp=lpath;
        lpath = new ArrayList<>();
        fpath(root,q,new ArrayList<>());
        List<TreeNode> pathq=lpath;

        for(int i=0;i<pathp.size();i++){
            if(i>=pathq.size()){
                return pathq.get(pathq.size()-1);
            }
            if(pathp.get(i)!=pathq.get(i)){
                return pathp.get(i-1);
            }
        }
        return pathp.get(pathp.size()-1);
    }
    private void fpath(TreeNode root, TreeNode node, List<TreeNode> path){
        path.add(root);
        if(root==node) {
            lpath=new ArrayList(path);
            return;
        }
        if(root.left!=null){
            fpath(root.left,node,path);
        }
        if(root.right!=null){
            fpath(root.right,node,path);
        }
        path.remove(path.size()-1);
    }
}
