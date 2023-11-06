class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root ){
        //base
        if(root == null) return;
        if(count > 0)
        inorder(root.left);
        count--;
        if(count == 0){
            result = root.val;
            return;
        }
        if(count > 0){
            inorder(root.right);
        }
    }
}


// TC : O(n)
// SC : O(n)

/**
 * In Bruteforce, We can maintain a list and store all the numbers inside a list and we can remove the kth smallest from that list.
Another approach is to maintain a counter and find out kth smallest element. This will work because its a BST

 * 
 */