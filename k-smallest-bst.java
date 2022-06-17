// Time Complexity :O(logn + k)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes



class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> st = new LinkedList<>();
        // stack to store the node pointers.

        while(true){

            while(root!=null){
                st.push(root);
                root = root.left;
            }
            // traversing to the leftmost of a node and inserting it into stack.
            root = st.pop();
            k--;
            if(k==0){
                // if its Kth smallest then return it.
                return root.val;
            }

            root = root.right;
            //move to the next largest node which is at the right in BST.
        }
    }
}