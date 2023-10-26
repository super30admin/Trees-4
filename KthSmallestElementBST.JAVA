class Solution {
    int cnt;
    int answer;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(root == null){
            return -1;
        }
        cnt=k;
        answer = -1;
        inorder(root);
        return answer;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null){
            return;
        }
        //logic
        inorder(root.left);
        cnt--;
        if(cnt==0){
            answer = root.val;
            return;
        }
        inorder(root.right);
    }
}