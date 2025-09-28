/**
TC: O(n) n: no of nodes
SC: O(h) h: height of the tree, if skewed tree then O(n).
Approach: Do DFS with backtracking, whenever we find either of the node p or q, we add the path to the listP or ListQ with extra addition of the p and q, once we find both the nodes, we compare the values in the path and the last similar value is returned as that the common ancestor.
 */

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
    ArrayList<TreeNode> pathP;
    ArrayList<TreeNode> pathQ;
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pathP = null;
        this.pathQ = null;
        this.result = null;
        helper(root,p,q, new ArrayList<>());
        

        for(int i =0; i<pathP.size(); i++){
            if(pathP.get(i).val != pathQ.get(i).val)
                break;
            result = pathP.get(i);
        }

        return result;
    }


    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        if(root == null)
            return;
        
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        if(pathP != null && pathQ != null){
            return;
        }

        helper(root.left,p,q, path);
        helper(root.right,p,q, path);
        path.remove(path.size()-1);
    }
}