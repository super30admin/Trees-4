import java.util.ArrayList;
import java.util.List;

//Approach: Backtracking
//1. Here I have called the helper function twice to get the path of the p and q nodes, wherein if a node is equal to p or q it is added twice in the path. 
//2. Then we iterate over the paths and if at any point the nodes are not equal we fallback and return the before node.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        List<TreeNode> path1 = new ArrayList<>();
        helper(root, p, path1);
        List<TreeNode> path2 = new ArrayList<>(); 
        helper(root, q, path2);
      /*  for(int i=0;i<path1.size();i++)
        {
            System.out.print(path1.get(i).val+"--");
        }
        System.out.println();
        for(int i=0;i<path2.size();i++)
        {
            System.out.print(path2.get(i).val+"--");
        }*/
        for(int i=0;i<path1.size();i++)
        {
            //System.out.println(path1.get(i).val+"--");
            if(path1.get(i) != path2.get(i))
                return path1.get(i-1);
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, List<TreeNode> path)
    {
       
        //base
        if(root == null)
            return;
        if(root == p)
        {
            path.add(root);
        }
        
        //logic
        path.add(root); //--action
        
        //recurse
        helper(root.left, p, path);
        if(path.get(path.size()-1) == p)return;
        //root = st.pop()
        helper(root.right, p, path);
        if(path.get(path.size()-1) == p)return;
        //backtrack
        path.remove(path.size()-1);
    }
}
//Time Complexity : O(n) since we will be visiting all the nodes at any point of time
//Space Complexity : O(2h) since we might have to keep the path in two arraylists. 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :


//Approach: Recursion
//1. Here we have done recursion and tried finding the nodes p and q along the way. If for any node p or q is found we are passing it all the way up through the root.

class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left  = helper(root.left, p, q);
        TreeNode right = helper(root.right, p ,q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        else
            return null;
    }
}
//Time Complexity : O(n) since we will be visiting all the nodes at any point of time
//Space Complexity : O(h) height of the tree for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :