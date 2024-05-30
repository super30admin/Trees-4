import javax.swing.tree.TreeNode;
// TC: O(n)
// SC: O(n)
public class Problem1 {
    TreeNode result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        this.count=0;
        helper(root,k);
        return result.val;
    }

    private void helper(TreeNode root, int k){
      if (root==null) return;
      
      if(result==null) helper(root.left, k);
      
      count++;
      if(count==k) result = root;

      if(result==null) helper(root.right,k);

    }
}
