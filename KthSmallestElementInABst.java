// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : The kth smallest element will mostly lie to the left part, if not then the right part of the tree. Hence recurse to the leftmost part of the tree, decrease value of k, as the lowest element is done. then goto the right sub tree. When k == 0, we have found the kth smallest element.

public class KthSmallestElementInABst {
    int k; 
    int res;
    
    int  i = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        
        this.k = k;  
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root){
        if(root == null || k < 0) return;
        dfs(root.left);
        
        k = k - 1;
        if(k == 0){
            res = root.val;
        }
        dfs(root.right);
    }
}
