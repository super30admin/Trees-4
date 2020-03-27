// Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
// Brute force 
//Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, k, list);
        return list.get(k - 1);
    }
    
    public void inorder(TreeNode root, int k, List<Integer> list) {
        if(root == null){
            return;
        }
        
        inorder(root.left, k, list);
        
        list.add(root.val);
        
        inorder(root.right, k, list);
    }
}