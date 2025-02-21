import java.util.PriorityQueue;

//Tc: O(klogn)
//Sc : O(n)
class kThSmallestInBST {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        dfs(root);
        int cnt = 1;
        while (cnt < k) {
            pq.poll();
            cnt++;
        }
        return pq.poll();
    }

    private void dfs(TreeNode root) {
        // base
        if (root == null) {
            return;
        }
        pq.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
//inorder travesal optimized
//TC: O(k+h)
//SC: O(h)

class kThSmallestInBST2 {
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        inorder(root,k);
        return result;
    }
    private void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        inorder(root.right,k);
    }
}