//Time : O(n)
//Space : O(n)

//Approach:
// Do a inorder traversal and store results in a list and return the required element accordingly as inorder traversal for a 
// BST gives a sorted order in ascending order.
class Solution {
    List<Integer> result = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0 ;
        inTraverse(root);
        return result.get(k-1);
    }
    
    public void inTraverse(TreeNode node){
        if(node == null)
            return;
        inTraverse(node.left);
        result.add(node.val);
        inTraverse(node.right);
    }
}
