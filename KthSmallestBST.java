
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

// Time Complexity :O(log n) where n is the number of nodes in the tree
// Space Complexity :O(log n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode :yes
public class KthSmallestBST{
    private int count;
    private TreeNode result;

    public int kthSmallest(TreeNode root, int k) {

        count = k;
        inorder(root);
        return result.val;
    }

    private void inorder(TreeNode root){

        if(root == null){
            return;
        }

        inorder(root.left);
        count--;
        if(count == 0){
            result = root;
        }
        inorder(root.right);
    }
}

// Time Complexity :O(ln) where n is the number of nodes in the tree
// Space Complexity :O(log n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode :yes
 class KthSmallestBSTBruteForce {
    private int count;
    private int value;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return value;
    }

    private void inorder(TreeNode node){

        //base
        if(node == null) return;

        //logic
        inorder(node.left);
        count++;
        if(count == k){
            value = node.val;
            return;
        }
        inorder(node.right);
    }
}
