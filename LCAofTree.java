// Approach 1: Top-down
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We use backtracking to find the paths to the nodes P and Q
// We then compare the paths and find the index where the values are not the same, the prev value will be the LCA

class Solution {
    List<TreeNode> pathP, pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, new ArrayList<>());
        for(int i=0;i<pathP.size();i++){
            // System.out.println(pathP.get(i).val);
            if(pathP.get(i)!=pathQ.get(i))
                return pathP.get(i-1);
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        if(root ==null)
            return;
        path.add(root);
            if(root == p)
        {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q)
        {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}

// Approach 2: Bottom up
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Here we dont use auxilary data structure, only recursion stack 
// We take a bottom up approach and return node to parent if p/q exists, else we return null

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if(left==null && right ==null)
            return null;
        if(left!=null && right==null)
            return left;
        else if(left==null && right!=null)
            return right;
        else
            return root;
    }
}