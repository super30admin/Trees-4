// Time Complexity : O(n)
// Space Complexity : O(n)
// This solution worked on LeetCode
// We would be using in-order traversal of the BST using stack. 

// Iterative Solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(true){
            while(root != null){
                st.push(root);        // add the left elements of the tree to the stack until null is hit
                root = root.left;
            }
            root = st.pop();        // pop the top element from the stack since the lowest element will be at the top
            k--;                    //  decrement the k
            if(k == 0)  return root.val;      // if k becomes 0 return the popped element in root
            root = root.right;              // traverse to the right of the root. 
        }
    }
}


