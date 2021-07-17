# Trees-4

## Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

//Time Complexity = O(n)
//Space Complexity = O(n)
class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result = -1; 
        if(root == null) return result; 
        inorder(root,k);
        return result;
    }
    private void inorder(TreeNode root, int k){
        //base
        if(root == null) return; 
        
        //logic
        if(result == -1)
        inorder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        if(result == -1)
        inorder(root.right, k); 
    }
    
}

## Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

//Time Complexity = O(log(n))
//Space Complexity = O(1)
//Iterative approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        
    while(true){    
        if(root.val > p.val && root.val > q.val) root = root.left;
        else if(root.val < p.val && root.val < q.val) root = root.right; 
        else return root; 
    }
        
    }
}

## Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## Approach 1

//Time complexity = O(n)
//Space Complexity = O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
       
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root; 
        else if(left != null) return left;
        else if(right != null) return right; 
        else return null; 
    }
}

## Approach 2

//Time Complexity = O(n)
//Space Complexity = O(n)
class Solution {
    List<TreeNode> path1; 
    List<TreeNode> path2; 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; 
        helper(root, p, q, new ArrayList<>());
        
        for(int i = 0; i < path1.size(); i++){
            if(path1.get(i) != path2.get(i))
                return path1.get(i-1); 
        }
        return null; 
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return; 
        if(root == p){
            path1 = new ArrayList<>(path); 
            path1.add(p);
            path1.add(p);  
        }
        
         if(root == q){
            path2 = new ArrayList<>(path); 
            path2.add(q);
            path2.add(q); 
        }
        
        //logic
        //action
        path.add(root); 
        
        //recursion
        helper(root.left, p , q , path); 
        helper(root.right, p, q, path);
        
        //backtrack
        path.remove(path.size() - 1); 
    }
}