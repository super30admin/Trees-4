// Time Complexity : O(n + m)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    List<TreeNode> path = new ArrayList<>();
    List<TreeNode> pathQ;
    List<TreeNode> pathP;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);

        int size = pathP.size() > pathQ.size()? pathP.size() : pathQ.size();
        for(int i = 0; i < size; i ++){
            if(pathP.get(i).val != pathQ.get(i).val){
                return pathP.get(i - 1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root == null) return;

        //logic
        //action
        path.add(root);

        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }

        //recurse
        helper(root.left,p,q);
        //conditional recursion
        if(pathQ == null || pathP == null){
            helper(root.right,p,q);
        }
        
        //backtracking
        path.remove(path.size() - 1);
    }
}