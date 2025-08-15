class Solution {
    int cnt;
    int answer = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        this.cnt = k;

        helper(root);
        return answer;
    }

    public void helper(TreeNode root){
        if(root==null || answer!=-1){
            return;
        }

        helper(root.left);
        cnt--;
        if(cnt==0){
            answer = root.val;
        }

        helper(root.right);
    }
}
