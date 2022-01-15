// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Bottom up recursion/backtracking: Faster in this case
// Time Complexity = O(n)
// Space Complexity = O(h)
// Bottom up recursion: Faster in this case
// Time Complexity = O(n)
// Space Complexity = O(h)

// Traverse left and right children till the leaf nodes, and return the value of p or q if you find it, otherwise return null.
// have if .. else conditions where you return the value that you get from the children, if both children give you non null values return root, otherwise pass on the non-null values
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if (root == null || root == p || root == q) return root;

        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right == null) {
            return left;
        }
        if (right != null && left == null) {
            return right;
        }
        else {
            return root;
        }
    }
}



// Top down recursion/backtracking: Slower in this case
// Time Complexity = O(n)
// Space Complexity = O(n) or O(h+h)=O(h)
class Solution {
    ArrayList<TreeNode> pathP, pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        backtrack(root, p, q, new ArrayList<>());

        for (int i=0; i< pathP.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i-1);
            }
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base
        if (root == null) return;

        //logic
        //action
        path.add(root);                 // add node to the path in each step
        if (root == p) {
            pathP = new ArrayList<TreeNode>(path);      // save the path to pathP, when you find q in the BT
            pathP.add(root);            // add an extra p at the end of pathP, for matching after backtracking is done
        }
        else if (root == q) {
            pathQ = new ArrayList<TreeNode>(path);      // save the path to pathQ, when you find q in the BT
            pathQ.add(root);            // add an extra q at the end of pathQ, for matching after backtracking is done
        }

        //recurse                          traverse the left and right side
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);

        //backtrack
        path.remove(path.size()-1);
    }
}