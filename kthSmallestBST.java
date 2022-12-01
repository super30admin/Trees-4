package s30.trees.trees4;

import s30.trees.TreeNode;

//Algo: using BST inorder traversal, which gives a sorted traversal
//traverse until we find the kth smallest element.


//TC: O(h+k);
//SC: O(h)
public class kthSmallestBST {
    private int k, ans;

    public int kthSmallest(TreeNode root, int k) {

        this.k = k;

        kthSmallest(root);

        return ans;
    }


    private void kthSmallest(TreeNode node){
        //base
        if(node == null) return;

        //recurse case

        kthSmallest(node.left);

        k--;
        if(k ==0) ans = node.val;

        if(k!=0) kthSmallest(node.right);
    }


    public static void main(String[] args) {

    }
}
