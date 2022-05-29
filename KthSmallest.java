// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Run inorder DFS. ** in BST when running inorder, we get the values in ascending order. Keep decrementing k and store result when k=0
public class KthSmallest {
    int result=-1, cnt;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return result;
        cnt=k;
        inorderDfs(root,k);
        return result;
    }

    private void inorderDfs(TreeNode root, int k){
        if(root==null) return;

        inorderDfs(root.left,k);
        cnt--;
        if(cnt==0){
            result=root.val;
        }

        if(result==-1)
            inorderDfs(root.right,k);
    }
}
