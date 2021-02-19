class Solution {
    /*
      Time : O(N) | N being number of nodes in a tree since worst case k = n;
      Space : O(N) | max n/2 leaf nodes could be in a stack.
      Leetcode : YES
    */
    
    /*
      Approach : do inorder and return kth element from beginning.
    */
    public int KthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr =root;
        
        while(!stk.isEmpty() || curr != null){
            while(curr != null){
                stk.push(curr);
                curr = curr.left;
            }
            k--;
            curr = stk.pop();
            if(k == 0){
                return curr.val;
            }
            
            curr = curr.right;
        }
        
        return -1;
    }
}
