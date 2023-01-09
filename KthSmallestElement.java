 //Time complexity is O(k) as we process only k elements
 //Space complexity is O(k)
class Solution {
    int K=0;
    List<Integer> result = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        K=k;
        helper(root);
        
        return result.get(k-1);
    }
    public void helper(TreeNode root){
        if(root==null || result.size()>=K){
            return;
        }
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}