// Time Complexity : O(n) -> number of nodes
// Space Complexity : O(h) -> height of the tree -> for recursive stack and for the paths array
// Did this code successfully run on Leetcode : Yes
import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p ,q,new ArrayList<TreeNode>());
        for(int i = 0 ; i<pathP.size(); i++)
        {
            if(pathP.get(i)!= pathQ.get(i))
            {
                return  pathP.get(i-1);
            }
        }
        return null;
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base case
        if(root == null) return;

        //logic
        //action
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
        if(pathP == null || pathQ == null)
        {
            //recurse
            helper(root.left,p,q,path);
            helper(root.right,p,q,path);
        }
        //backtrack
        path.remove(path.size()-1);
    }
}