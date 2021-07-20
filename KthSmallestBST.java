// Time Complexity : O(N) where N is the number of elements
// Space Complexity : O(N) where N is the number of elements in minHeap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
	1. traverse through all the elements in the BT and add them to a minHeap
	2. Remove the top elements just before K.
	3. Since it's a minHead the top most element would be the Kth smallest element
*/


// Your code here along with comments explaining your approach
class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        traverseTree(root);
        
        for(int i=1;i<k;i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
    
    public void traverseTree(TreeNode root) {
        minHeap.add(root.val);
        if(root.left != null) traverseTree(root.left);
        if(root.right != null) traverseTree(root.right);
    }
}
