//TC - O(k)
//SC - O(h)
//inorder iterative

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        
        int count = 0;
        
        while(root != null || !stk.isEmpty())
        {
            while(root != null)
            {
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            ++count;
            
            if(count == k) return root.val;
            
            root = root.right;
        }
        
        return -1;
    }
}

//TC - O(k) or O(n) worst case when k = n
//SC - O(h)
//inorder recursive

class Solution {
    int count = 0;
    
    int res = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        
        inorder(root);
        
        return res;
    }
    
    private void inorder(TreeNode node)
    {
        //base
        if(node == null) return;
        
        //logic
        inorder(node.left);
        --count;
        
        if(count == 0)
            res = node.val;
        
        inorder(node.right);
    }
}
