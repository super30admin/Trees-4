// Time complexity = O(n)
// Space complexity = O(n)
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
    List<TreeNode> listP;
    List<TreeNode> listQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, new ArrayList<TreeNode>(), p, q);        
        int i =0;
        while(i< listP.size() && i< listQ.size()) {
            if(listP.get(i) != listQ.get(i)) {
                return listP.get(i-1);
            }
            i++;
        }
        return null;
    }
    
    private void helper(TreeNode root, List<TreeNode> path, TreeNode p, TreeNode q) {
        //  base
        if(root==null) {
            return;
        }
        // logic
        path.add(root);
        if(root==p) {
            listP = new ArrayList<>(path);
            listP.add(root); //  to force uncommonality. eg - [3,5,2] and [3,5,2,4]
            // one goes out of bounds if we don't force uncommonality.so we force it.
        }
        
        if(root==q) {
            listQ = new ArrayList<>(path);
            listQ.add(root);//  to force uncommonality.
        }
        
        
        helper(root.left, path, p, q );
        helper(root.right, path, p, q );
        path.remove(path.size()-1);
        return;
        
    }
}