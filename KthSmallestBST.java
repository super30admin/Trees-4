/*
The following approach uses an iterative approach in-order traversal on the BST to find the Kth smallest element.
It keeps a count of all the elements being popped of the recursive stack in order to find the element.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> st = new Stack();
        int count = 0;
        
        while(root != null || !st.isEmpty())
        {
            while(root != null)
            {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            count++;
            
            if(count == k)
                return root.val;
            
            root = root.right;
        }
        
        return 0;
    }
}