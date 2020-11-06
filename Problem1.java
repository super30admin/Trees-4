// Time Complexity : O(n)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes, 3ms
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Maintain a Max heap and add the elements keeping only k elements, and traverse the tree in an inorder manner


class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n2 - n1);
    
    public int kthSmallest(TreeNode root, int k) {
        
        traverse(root,k);
        
        return pq.peek();
}
    
   public void traverse(TreeNode root, int k){
    
       if(root == null){
           return;
       }
        
       pq.add(root.val);
    
       if(pq.size() > k){
           pq.remove();
       }
    
       traverse(root.left, k);
    
       traverse(root.right, k);
}
    
}