// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/*
 * 1 - We will have two Array lists each for p and q. This will store the path upto these nodes. 
 * 2 - In the end, we traverse the lists until the elements are not equal anymore and return the element - 1 because the nodes will share a common path.
 * 3 - Helper function - add the root, check if the root is equal to either p or q. If yes, make a copy of the path and add p/q to it. Recurse on both left and right nodes and then backtrack.
 */

public class BinaryLCA {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        
        helper(root,p,q,new ArrayList<>());
        
        for(int i = 0; i < pathP.size();i++)
        {
            if(pathP.get(i) != pathQ.get(i))
                return pathP.get(i - 1);
        }
        
        return null;
    }
    
    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {
        //base
        if(root == null)
            return;
        
        //logic
        //action
        path.add(root);
        if(root == p)
        {
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        
        if(root == q)
        {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        
        //recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}
