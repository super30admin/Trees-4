// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == null || q == null) {
            return null;
        }
        return searchAncestror(root, p, q);
    }
    private TreeNode searchAncestror(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.left == p && root.right == q) {
            return root;
        }
        if (root.left == q && root.right == p) {
            return root;
        }
        if (root == p && (root.left == q || root.right == q)) {
            return p;
        }
        if (root == q && (root.left == p || root.right == p)) {
            return q;
        }
        if (p.val < root.val && q.val < root.val) {
            return searchAncestror(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return searchAncestror(root.right, p, q);
        } 
        return root;
    }
}


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
        if (root == null) {
            return null;
        }
        if (p == null || q == null) {
            return null;
        }
        boolean p_found = false;
        boolean q_found = false;

        p_found = checkifpresent(root, p);
        q_found = checkifpresent(root, q);
        if (p_found == true && q_found == true) {
            return searchAncestor(root, p, q);            
        } else {
            System.out.println("here");
            return null;
        }

    }
    private TreeNode searchAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null ){
            return null;
        } 
        if (root.left == p && root.right == q) {
            return root;
        }
        if (root.left == q && root.right == p) {
            return root;
        }
        if (root == p && (root.left == q || root.right == q)) {
            return root;
        }
        if (root == q && (root.left == p || root.right == p)) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftsb=searchAncestor(root.left, p, q);
        TreeNode rightsb=searchAncestor(root.right, p, q);
        if (leftsb != null && rightsb != null) {
            return root;
        }

        if (leftsb != null) {
            return leftsb;
        }
        return rightsb;
    }

    private boolean checkifpresent (TreeNode root, TreeNode check) {
        if (root == null) {
            return false;
        }
        if (root.left == check || root.right == check) {
            return true;
        }
        if (root == check) {
            return true;
        }
        return false;
    }
}



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
    int cnt=0;        
    int answer = -1;
    public int kthSmallest(TreeNode root, int k) {

        TreeNode curr=inorder(root, k);
        return answer;
    }

    private TreeNode inorder(TreeNode root, int k) {
        if (root == null) {
            return root;
        }
        inorder(root.left,k);
        cnt++;
        if (cnt == k) {
            answer = root.val;
        }
        inorder(root.right,k);
        return root;
    }
}
