// Time Complexity : O(n)
// Space Complexity : O(h)

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
        if(root == null)
            return null;
        helper(root, p, q, new ArrayList<TreeNode>());
        int i = 0;
        while(pPath.get(i) == qPath.get(i))
            i++;
        return pPath.get(i - 1);
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null)
            return;
        if(root == p){
            pPath = new ArrayList<>(path);
            pPath.add(root);
            pPath.add(root);
        }
        if(root == q){
            qPath = new ArrayList<>(path);
            qPath.add(root);
            qPath.add(root);
        }
        if(pPath != null && qPath != null)
            return;
        //logic
        path.add(root);
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        path.remove(path.size() - 1);
    }
}