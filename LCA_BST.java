// Time Complexity : O(log n) as we traversing through left or right subtree each time based on value
// Space Complexity : O(h) h=height of the stack for recursive, for iterative it is O(1)

// Recursive
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val < root.val && q.val < root.val) { // Traverse left subtree if both the nodes are having lesser values than root
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val) {  // Traverse right subtree if both the nodes are having greater values than root
            return lowestCommonAncestor(root.right,p,q);
        } 
        else return root;
    }
}

// Iterative 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        while(root!=null) {
           if(p.val < root.val && q.val < root.val) {  // Traverse left subtree if both the nodes are having lesser values than root
               root = root.left;
            }
        else if(p.val > root.val && q.val > root.val) { // Traverse right subtree if both the nodes are having greater values than root
            root=root.right;
        } 
        else return root; 
        }
        return null;
    }
}