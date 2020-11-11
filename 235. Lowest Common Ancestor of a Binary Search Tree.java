class Solution {// time of O(n) and space  O(n) for this recursive version
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val> root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p ,q );
        else if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        else 
            return root ;
    }
}