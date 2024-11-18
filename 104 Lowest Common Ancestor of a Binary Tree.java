// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

 //aesha
 class Solution {
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p , q, new ArrayList<>());
        for(int i = 0; i < pathp.size(); i ++)
        {
                if(pathp.get(i) != pathq.get(i))
                {
                    return pathp.get(i-1);
                }
            
        }
        return null;   
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {

        if(root == null) return;
        
        path.add(root);
        if(root==p )
        {
            pathp = new ArrayList<>(path);
            pathp.add(root);
        }

        if(root==q)
        {
            pathq = new ArrayList<>(path);
            pathq.add(root);
        }

        helper(root.left, p, q, path);
        helper(root.right, p, q, path);

        // backtrack
        path.remove(path.size()-1);
    }
}