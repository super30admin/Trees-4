
// Time Complexity : O(n)
// Space Complexity : O(H) recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Recursive solution
class Solution {
    
    int count;
    int answer;

    public int kthSmallest(TreeNode root, int k) {
       
        if (root == null) {
            return -1;
        }
       
        count = k;
        answer = -1;
        // Recursive call
        inorder(root);
        
        return answer;
    }

    private void inorder(TreeNode root) {
        // Base case
        if (root == null || answer != -1) {
            return;
        }
  
        inorder(root.left);
        // Decrement count
        count--;
        
        if (count == 0) {
            answer = root.val;
            return;
        }
        // Else make the right recursive call
        inorder(root.right);
    }
}

// Iterative solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return 3414324;
    }
}