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
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    void recursiveFunction(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path) {
        //base
        if(root == null) {
            return;
        }
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
           pathP.add(root);
        }
        
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        //logic
        
        recursiveFunction(root.left,p,q,path);
        recursiveFunction(root.right,p,q,path);
        path.remove(path.size()-1);



    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path = new ArrayList<>();
        recursiveFunction(root,p,q,path);
        for(int i =0; i<pathP.size();i++) {
            if(pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i-1);
            }
        }
        return null;
    }
}