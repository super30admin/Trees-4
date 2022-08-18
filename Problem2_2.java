//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        
        if(root == null)
            return null;
        
        while(root != null){
            
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            
            else if(root.val < p.val && root.val < q.val)
                root = root.right;
            
            else
                return root;
        }
        
        return null;
    }
}
