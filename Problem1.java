

//Time Complexity: O(n) where n is the number of nodes in the tree
//Space Complexity: O(H) where H is the height of the tree

//We use recursion to do an inorder traversal of the tree. 
// We maintain a count of nodes visited so far. When the count reaches k, 
// we store the value of the current node as the result. 
//we use inorder traversal because it visits nodes in ascending order for a BST.


class Solution {
    int c,res;
    public int kthSmallest(TreeNode root, int k) {
        this.c=0;
        this.res=0;
        helper(root,k);
        return res;
    }
    void helper(TreeNode root,int k){
        if(root==null)
            return;

        helper(root.left,k);

        c++;
        if(c==k)
            res=root.val;

        helper(root.right,k);

    }
}