// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>(); // to process the tree nodes
        while(root!=null || !st.isEmpty()) // till both root becomes null and stack becomes empty
        {
            while(root!=null) // till root becomes null
            {
                st.push(root); // push elements to stack
                root = root.left; // go to left of root
            }  
            
           
            root = st.pop(); // pop the element of stack and assign it to root
            k--; // decrement k
            if(k==0) // when k becomes zero
                return root.val; // return the kth smallest element value
            root = root.right; // traverse root right
        }
        
        return -1;
    }
}

// Time Complexity : O(n)
// Space Complexity :O(h) recursive stack space
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count; // global count variable
    int result; // to store the kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        //edge case
       if(root == null)
           return -1;
        count = k; // assign count as k
        inorder(root); // call the inorder traversal function on root
        return result;
    }
    
    private void inorder(TreeNode root)
    {
        //base
        if(root == null)
            return;
        
        //logic
        inorder(root.left); // traverse left
        count--; //decrease count 
        if(count == 0) /// when count becomes zero i.e we have traversed k elements
            result = root.val; // store the value of root in result
        inorder(root.right); // traverse right
        
    }
}

// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None



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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //if values less than root
        if(p.val< root.val && q.val < root.val)
           return lowestCommonAncestor(root.left, p, q); // we go to left subtree
        else if(p.val > root.val && q.val > root.val)  //if values greater than root
           return lowestCommonAncestor(root.right, p, q); // we go to right subtree
        else 
            return root; // found the splitting point
        

    }
} 

//Iterative solution

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root!=null) // till root does not become null
        {
         if(p.val< root.val && q.val < root.val) // if values less than root
                root = root.left; // go to left subtree
         else if(p.val > root.val && q.val > root.val) // if values greater than root
                root = root.right; // go to right subtree
         else 
            return root;   // return the split point
        }  

        return null;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None



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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null || root.val == p.val || root.val == q.val) // if value found or null found
            return root; // return the root value
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q); // go left and store the value returned 
        TreeNode right = lowestCommonAncestor(root.right, p, q); // go right and store the value returned
        
        //branch conditions
        if(left!=null && right!=null)  // if both left and right variable value exists
            return root; // the split is found
        else if(left!=null) // if left value is there only
            return left; // return left value from the branch
        else if (right != null) // if right value is there only
            return right;// return right value from the branch
        else 
            return null; // return null 
    }
}