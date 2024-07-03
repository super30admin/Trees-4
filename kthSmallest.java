//time O(n)
//space O(h) height of tree

class Solution {
    PriorityQueue<TreeNode> pq;
    int kNum = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        inorder(root, k);
        return kNum;
        // return pq.size();
    }
    
    private void inorder(TreeNode root, int k) {
        //base
        if(root == null) return;

        

        //logic
        inorder(root.left, k);
        count++;
        if(k == count) {
            kNum = root.val;
        }
        inorder(root.right, k);
    }
    
}
