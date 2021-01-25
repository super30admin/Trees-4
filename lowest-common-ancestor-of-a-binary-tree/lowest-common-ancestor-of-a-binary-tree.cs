/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        IList<TreeNode> plist = new List<TreeNode>();
        IList<TreeNode> qlist = new List<TreeNode>();
        Helper(root,p,plist);
        Helper(root,q,qlist);
        
        TreeNode res = null;
        int i=0;
        int j=0;
        
        while(true)
        {
            if(i >=plist.Count)
            {
                break;
            }
            if(j >=qlist.Count)
            {
                break;
            }
            if(plist[i] != qlist[j])
            {
                break;
            }
            
            res = plist[i];
            i++;
            j++;
        }
        
        return res;
        
    }
    
    private void Helper(TreeNode node,TreeNode target,IList<TreeNode> path)
    {
        if(node ==null)
        {
            return;
        }
        
        path.Add(node);
        
        if(node==target)
        {
            return;
        }
        Helper(node.left,target,path);
        if(path[path.Count-1]==target)
        {
            return;
        }
        Helper(node.right,target,path);
        
        if(path[path.Count-1] == target)
        {
            return;
        }
        
        path.RemoveAt(path.Count-1);
    }
}
