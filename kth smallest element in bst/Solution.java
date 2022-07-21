// Time Comlpexity: O(n)
// Space Complexity: O(n)
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        pq.add(root.val);
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        for(int i=0;i<k-1;i++){
            pq.poll();           
        }
        return pq.poll();
    }
}
