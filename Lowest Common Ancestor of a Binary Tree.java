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

    ArrayList<TreeNode> path1 = new ArrayList<>();
    ArrayList<TreeNode> path2 = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        printPath1(root,p);
        printPath2(root,q);

        int index = Math.min(path1.size(),path2.size());

        for(int i = index-1 ; i>=0 ; i-- )
        {
            if(path1.get(i).val == path2.get(i).val)
            {
                return path1.get(i);
            }
        }

        return null;
    }

    public Boolean printPath2(TreeNode root, TreeNode dest)
    {
		if(root==null) return false;

		if(root==dest||printPath2(root.left,dest)||printPath2(root.right,dest))
        {
			path2.add(0,root);
			return true;
	    }

		return false;

    }
    public Boolean printPath1(TreeNode root, TreeNode dest)
    {
		if(root==null) return false;

		if(root==dest||printPath1(root.left,dest)||printPath1(root.right,dest))
        {
			path1.add(0,root);
			return true;
	    }

		return false;

    }
}
