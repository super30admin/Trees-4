// Time Complexity :O(k)
// Space Complexity :O(1)
class Solution {
   int count=0;
   int res=-1;
   public int kthSmallest(TreeNode root, int k) {
       inorder(root,k);
       return res;
   }

   public void inorder(TreeNode root,int k){
       if(root==null){
           return;
       }
       inorder(root.left,k);
       count++;
       if(count==k){
           res= root.val;
       }

       if(count<k){
           inorder(root.right,k);
       }

   }

}

--------------------------------------------------------------
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;

        int pVal = p.val;

        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
         
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
        }
    }
}
