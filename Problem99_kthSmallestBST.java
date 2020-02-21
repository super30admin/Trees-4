//DFS using Stack
//Time Complexity: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> st = new Stack<>();
        //iterate over root.left to reach the left most root
        //and keep adding the elements to stack
        //since leftmost node is the smallest
        while (root != null) {
            st.push(root);
            root = root.left;
        }
          
        while (k != 0) {
            //keep popping to k times
            TreeNode n = st.pop();
            k--;
            //if k=0, found smallest node on the left
            if (k == 0) return n.val;
            //else the node is on right subtree
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
      
        return -1; // never hit if k is valid
    }
}