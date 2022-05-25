//we know that in a inorder traversal the elements of tree will be sorted in ascending order and that the kth largest elemnt will be the kth element in an inorder list
// this appraoch could be more optimized
// tc: o(n) sc: o(h)
class Solution {
    int cnt = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        cnt = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        cnt--;
        if(cnt == 0) {
            result = root.val;
            return; // this return doesnt do much it jsut prevents the the current recursive call from progressing towards the right subtree. instead what we can do is
        }

        if(result == -1) inorder(root.right); // good optimization cuz for the elemts still in recursive stack we wont traverse them inless we hgave result set as -1
    }
}