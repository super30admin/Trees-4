/*
Time Complexity: O(N) N is the number of the all the nodes in the tree
Space Complexity: O(H) H is the height of the tree
Run on leetcode: Yes
Any difficulties: no

Approach:
1. I will be using properties of Binary Search Tree, it's property is when we do inorder traversal on it it gives
a sorted array in the result
2. I will do inorder traversal keeping count of K in mind and for every call will decrement value of k and now if the value of
k becomes zero then that would be our answer

 */
public class KthSmallestElementInBST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public int k;
    public int ans;
    public int kthSmallestElementInBST(TreeNode root, int k){
        if(root == null ){
            return -1;
        }
        this.k = k;
        this.ans = -1;

        inorderTraversal(root);
        return this.ans;
    }

    public void inorderTraversal(TreeNode root){
        if(root == null || k == 0){
            return;
        }

        inorderTraversal(root.left);

        k--;
        if(k == 0){
            ans = root.val;
        }

        inorderTraversal(root.right);
    }
    public static void main(String[] args){
        KthSmallestElementInBST obj = new KthSmallestElementInBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println("Kth Smallest Element: "+obj.kthSmallestElementInBST(root, 1));
    }
}
