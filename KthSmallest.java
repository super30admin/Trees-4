// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class KthSmallest {
int cnt;
int result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }
    private void inorder(TreeNode root, int k){
        if(root!=null){
            inorder(root.left,k);
            cnt++;
            if(cnt==k){
                result = root.val;
                return;
            }
            if(cnt<k)
                inorder(root.right,k);
        }
    }
}