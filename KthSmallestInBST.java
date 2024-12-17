// Time complexity O(h + k)
// Space complexity O(h)
public class KthSmallestInBST {
    private int count = 0;
    private int result = -1;
    public int findKthSmallest(TreeNode root, int k ){
       inOrdedrTraversal(root, k);
          return result;
        }

        private void inOrdedrTraversal(TreeNode root,int k ){

        // base case
            if(root == null) {
                return;
            }
            // traverse left subtree
         inOrdedrTraversal(root.left, k);

            // process the current node
            count ++;
            if( count == k){
                result = root.val;
                return; // stop further traversal as we found k
            }
            // traverse right subtree
            inOrdedrTraversal(root.right, k);
    }
    public static void main(String[] args) {
        // Manually constructing the BST
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        // Finding the kth smallest element
        int k = 3; // Change this to test different values of k
        KthSmallestInBST tree = new KthSmallestInBST();
        int result = tree.findKthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
