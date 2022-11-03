//T.C- O(N)
//S.C- O(h)
//   Definition for a binary tree node.
  public class LCAinBT {
      int val;
      LCAinBT left;
      LCAinBT right;
      LCAinBT(int x) { val = x; }
  }
 

class Solution {
    public LCAinBT lowestCommonAncestor(LCAinBT root, LCAinBT p, LCAinBT q) {
        if(root==null || root==p|| root==q){
            return root;
        }
        LCAinBT left=lowestCommonAncestor(root.left,p,q);
        LCAinBT right=lowestCommonAncestor(root.right, p,q);
        
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
}