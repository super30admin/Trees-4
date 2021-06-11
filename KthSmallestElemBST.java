import java.util.ArrayList;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

// I have solved using O(n) space but can be solved in O(1) space
// making sure I decrement K everytime I pop element from stack under the hood

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class KthSmallestElemBST {
    ArrayList<Integer> result;
    
    public int kthSmallest(TreeNode root, int k) {
        result = new ArrayList<>();
        
        result=inorder(root);
        return result.get(k-1);
    }
    
    public ArrayList<Integer> inorder(TreeNode root) {
            if (root == null) 
                return result;
        
            inorder(root.left);
            result.add(root.val);
            inorder(root.right);
            return result;
  }
}
