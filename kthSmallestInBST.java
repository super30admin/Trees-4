//time - O(n)
//space - O(h)
class Solution {
    int result, count;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        result = -1;
        count = k;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root){
        if(root==null)
            return;

        dfs(root.left);
        count--;
        if(count==0){
            result = root.val;
            return;
        }
        dfs(root.right);
    }
}
