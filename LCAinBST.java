//T.C- O(N)
//A.C- O(h)
//   Definition for a binary tree node.
  public class LCAinBST {
      int val;
      LCAinBST left;
      LCAinBST right;
      LCAinBST(int x) { val = x; }
  }
 

class Solution {
    public LCAinBST lowestCommonAncestor(LCAinBST root, LCAinBST p, LCAinBST q) {
        if(root==null){
            return null;
        }
        int curr= root.val;
        if(curr>p.val && curr>q.val){
            return lowestCommonAncestor(root.left, p, q);
            
        }else if(curr<p.val && curr<q.val){
            return lowestCommonAncestor(root.right, p,q);
        }return root;
        
    }
}