import java.util.ArrayList;
import java.util.List;

public class problem3 {

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x)
        {
            val=x;
        }
    }
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q, new ArrayList<>());
        for (int i=0;i<pathP.size();i++)
        {
            if (pathP.get(i) != pathQ.get(i))
            {
                return pathP.get(i-1);
            }
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {
        //base case
        if (root == null)
            return;

        //logic

        //action
        path.add(root);
        if (p==root)
        {
            pathP= new ArrayList<>(path);
            pathP.add(root);
        }
        if (q==root)
        {
            pathQ= new ArrayList<>(path);
            pathQ.add(root);
        }

        //recurse
        helper(root.left,p,q, path);
        helper(root.right,p,q, path);
        path.remove(path.size()-1);


    }

}
