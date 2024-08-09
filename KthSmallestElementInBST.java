public class KthSmallestElementInBST {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) { //O(h) T.C, O(h) S.C
        this.count = k;
        this.result = 0;
        inorder(root); //inorder traversal of the tree
        return result;
    }

    private void inorder(TreeNode root) {
        //base
        if(root == null) return;

        //logic
        inorder(root.left);

        count--; //after each inorder traversal on the left, reduce the count
        if(count == 0) result = root.val; //if the count becomes 0, that means this is the kth smallest

        if(count != 0) inorder(root.right); //continue on the right side, only if the result has not been found yet
    }

    public static void main(String[] args) {
        // Constructing the following BST
        //        20
        //       /  \
        //      10  30
        //     /  \
        //    5   15
        //   / \    \
        //  3   7    17

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(17);

        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();

        // Test case 1: 3rd smallest element is 7
        int k1 = 3;
        System.out.println("The " + k1 + "rd smallest element is: " +
                kthSmallestElementInBST.kthSmallest(root, k1));

        // Test case 2: 5th smallest element is 15
        int k2 = 5;
        System.out.println("The " + k2 + "th smallest element is: " +
                kthSmallestElementInBST.kthSmallest(root, k2));

        // Test case 3: 1st smallest element is 3
        int k3 = 1;
        System.out.println("The " + k3 + "st smallest element is: " +
                kthSmallestElementInBST.kthSmallest(root, k3));

        // Test case 4: 6th smallest element is 17
        int k4 = 6;
        System.out.println("The " + k4 + "th smallest element is: " +
                kthSmallestElementInBST.kthSmallest(root, k4));
    }
}