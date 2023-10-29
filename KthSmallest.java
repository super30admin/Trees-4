

//T.C : O(n)
//S.C : O(H)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class KthSmallest {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int cnt, answer=-1;
    public int kthSmallest(TreeNode root, int k) {
        cnt =k;
        if(root == null){
            return -1;
        }
        inorder(root);
        return answer;

    }

    private void inorder(TreeNode root){
        //base
        if(root == null || answer != -1){
            return ;
        }

        //logic
        inorder(root.left);
        cnt--;
        if(cnt ==0){
            answer = root.val;
        }
        inorder(root.right);
    }
}
