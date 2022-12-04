class Solution {
    private int a;
        private int c;
        private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        r(root);
        return a;

    }
    private void r(TreeNode n){
        if(n == null){
            return;
        }
        r(n.left);
        ++c;
        if(c == k){
            a =n.val;
        }

        if(c<k){
            r(n.right);
        }
    }
}
//tc = O(h)
//sc = O(n)
