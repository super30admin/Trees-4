

//T.C : O(N)
//S.C : O(H)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class LCABST {



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null){
            return null;
        }
        else if(left != null && right == null){
            return left;
        }
        else if(left == null && right != null){
            return right;
        }
        else{
            return root;
        }


    }
}
