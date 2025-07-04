//time complexity- O(n)
//space complexity- O(h)
public class KthSmallestInBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return value;
    }
    static int count = 0;
    static int value = 0;
    private static void inorder(TreeNode root, int k) {
        if(root == null) return;

        inorder(root.left, k);
        count++;
        if(count == k) {
            value = root.val;
            return;
        }
        inorder(root.right, k);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        int k = 3;
        /*
                    5
                  /  \
                 3    6
               /
             2
           /
          1
         */
        System.out.println(k + " smallest number in the tree is :" + kthSmallest(root, k));
    }
}
