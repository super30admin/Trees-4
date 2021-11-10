import java.util.*;
public class Trees{
      // time complexity : N
    // space complexity : H
    // any doubts : no
    // did it run on leetcode : yes
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val<=root.val && q.val >= root.val) || (q.val<=root.val && p.val >= root.val)){
            return root;
        }else if(p.val < root.val && q.val <root.val){
            return lowestCommonAncestorBST(root.left,p,q);
        }else{
            return lowestCommonAncestorBST(root.right,p,q);
        }
    }

      // time complexity : N
    // space complexity : H
    // any doubts : no
    // did it run on leetcode : yes
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    int val=0;
    int lessval;
    public int kthSmallest(TreeNode root, int k) {
        lessval = k;
        helper(root);
        
        return val;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.left);
        lessval --;
        if(lessval==0) val = root.val;
        
        helper(root.right);
    }

      // List<TreeNode> plist;
    // List<TreeNode> qlist;
    // time complexity : N
    // space complexity : H
    // any doubts : no
    // did it run on leetcode : yes
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root== q)
            return root;
        TreeNode left = lowestCommonAncestorBT(root.left,p,q);
        TreeNode right = lowestCommonAncestorBT(root.right,p,q);
        if(left == null && right == null)return null;
        else if(left != null && right == null) return left;
        else if(left == null && right != null) return right;
        else return root;
            
        }

}