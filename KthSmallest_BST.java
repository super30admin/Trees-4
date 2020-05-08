// Time Complexity :O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    PriorityQueue<Integer> maxHeap;
    public int kthSmallest(TreeNode root, int k) {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        helper(root, k, 0);
        return maxHeap.peek();
        
    }
    
    public void helper(TreeNode root, int k, int count)
    {
        if(root == null)
            return;
        
        
        helper(root.left, k);
              
        if( maxHeap.size() == k)
        {
            if(maxHeap.peek() > root.val)
            {
                maxHeap.poll();
                maxHeap.offer(root.val);
            }
        }
         else
         {
             maxHeap.add(root.val);
        }
        
            
        
        helper(root.right, k);
    }
}
