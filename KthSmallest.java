import java.util.ArrayList;

/*
## Problem 1: Kth Smallest Element in a BST 
(https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

Time Complexity :   O (n) 
Space Complexity :  O (n) 
Did this code successfully run on Leetcode :    Yes (230. Kth Smallest Element in a BST)
Any problem you faced while coding this :       No
 */
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
    
// DFS: travel Inorder and store elements in List
// return k-1 th index element
class Solution {
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null)
            return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result = inorder(root, new ArrayList<>());
        return result.get(k-1);
    }
}