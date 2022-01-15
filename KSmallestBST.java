// Time Complexity: O(n)
// Space Complexity: O(h) h is height of the tree
// recursive w/o stack optimization, needs inorder traversal
public class KSmallestBST {
    int result = -1;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return result;
        count = k;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null)
            return;
     
        inorder(root.left);
        count--;
        if(count == 0)
        {
            result =  root.val;
            return;
        } // even after the return the stack will continue to unfold
        inorder(root.right);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(h) h is height of tree
// recursive with stack optimization
public class KSmallestBST {
    int result = -1;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        // in order traversal
        if(root == null)
            return result;
        count = k;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null)
            return;
     
        inorder(root.left);
        count--;
        if(count == 0)
        {
            result =  root.val;
            return;
        }
        if(count > 0) // this will cause the root to be executed only if entire left count was left
            inorder(root.right);
    }    
}
// Time Complexity: O(n)
// Space Complexity: O(h) h is height of tree
// iterative with stack optimization
public class KSmallestBST {
    public int kthSmallest(TreeNode root, int k)
    {
        // in order traversal
        if(root == null)
            return -1;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null)
        {
            while(root != null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0)
            {
            return root.val; 
            }  
            
            root = root.right;
        }
        return -1;
    }
}