/*Time Complexity : O(n)
  Space Complexity : O(N)
  Did it run on LeetCode : Yes.
  Any problems? No.

*/

class Solution {
    public int kthSmallest(TreeNode root, int k) 
    {
        List<Integer> list = new ArrayList<>();
        
        dfs(root, list);
        int ans = list.get(k-1);	// Since list is sorted after DFS, get the element at K-1 index.
           return ans;    	// return the element.
    } 
    public void dfs(TreeNode root, List<Integer> list)
    {
        if (root == null) return;	// If root is null, nothing more to traverse.
        dfs(root.left, list);	// Since it is a BST, DFS to the left most element since it is the smallest.
        list.add(root.val);	// Add the element to the list. This will make the list a sorted list.
        dfs(root.right, list);	// Move to the right now from left most.
    }
}