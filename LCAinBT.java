/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC : O(n)
//SC : O(h)
class Solution {
    List<TreeNode> pPath = new ArrayList();
    List<TreeNode> qPath = new ArrayList();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;

        helper(root,p,q,new ArrayList());
        System.out.println("pPath" + pPath);
        System.out.println("qPath" + qPath);
        for(int i=0;i<pPath.size();i++)
        {
            if(pPath.get(i)!=qPath.get(i))
                return pPath.get(i-1);
        }

        return null;
    }

    private void helper(TreeNode root,TreeNode p, TreeNode q, List path)
    {
        //base
        if(root==null||(!pPath.isEmpty()&&!qPath.isEmpty())) return;
        path.add(root);
        if(root==p)
        {
            pPath = new ArrayList(path);
            pPath.add(root);
        }
        if(root==q)
        {
            qPath = new ArrayList(path);
            qPath.add(root);
        }
        //logic
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}