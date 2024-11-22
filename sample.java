// Time Complexity : O(n) where n is number of nodes as tree traverses all the nodes.
// Space Complexity : O(h+n) where h is height of the tree due to recursion stack and n is size of result list.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// This solution finds the k-th smallest element in a Binary Search Tree (BST) using an in-order traversal approach. In-order traversal visits nodes in 
// ascending order for a BST. The kthSmallest method initializes an empty list result to store the elements of the BST in sorted order. The helper method 
// performs a recursive traversal: it first explores the left subtree (smallest elements), then adds the current node's value to result, and finally explores 
// the right subtree (larger elements). After the traversal, the k-th smallest element (index k - 1) is retrieved from the sorted list.

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
    List<Integer> result;
    public int kthSmallest(TreeNode root, int k) {
        this.result = new ArrayList<>();
        helper(root);
        return result.get(k-1);

    }

    private void helper(TreeNode root) {
        // base
        if(root == null) {
            return;
        }

        // logic
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}



// Time Complexity : O(h) where h is the height of the tree.
// Space Complexity : O(h) due to recursion stack.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// This solution efficiently finds the Lowest Common Ancestor (LCA) in a Binary Search Tree (BST) using the properties of BSTs. Starting from the root, the 
// algorithm checks if either of the nodes p or q matches the root. If so, the root itself is the LCA. If both p and q have values less than the root’s value, 
// the algorithm recursively searches in the left subtree. Conversely, if both values are greater than the root’s value, the search continues in the right 
// subtree. If the values diverge (one is smaller and the other is larger), the current root is the LCA because it lies between the two nodes in the BST.

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
        TreeNode curr = helper(root, p, q);
        return curr;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val == root.val || q.val == root.val) {
            return root;
        }

        if(p.val < root.val && q.val < root.val) {
            return helper(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val) {
            return helper(root.right, p, q);
        } 

        return root;
    }
}



// Time Complexity : O(n) where n is number of nodes in a tree as in the worst case scenario we will have to traverse all the nodes.
// Space Complexity : O(h) where h is height of the tree due to recursion stack.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// The given solution is a recursive method to find the lowest common ancestor (LCA) of two nodes p and q in a binary tree. Starting from the root, the 
// algorithm checks if the root is null or matches p or q; if so, it returns the root as a base case. It then recursively searches for p and q in the left and 
// right subtrees. After exploring both subtrees, if both p and q are found in different subtrees (i.e., both left and right are non-null), the current root 
// is the LCA. If only one subtree contains p or q, that subtree's result is returned. If neither subtree contains p or q, the method returns null. The 
// recursion unwinds, propagating the LCA up the call stack.

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
        
        if(root == null || root == p || root == q) {
            return root;
        }

        System.out.println(root.val);

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if(left != null && right != null) return root;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return null;

    }
}


