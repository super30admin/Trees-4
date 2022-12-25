// Time Complexity : O(n)
// Space Complexity :O(h)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        int cnt=0, res;
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root=s.pop();
            cnt++;
            if(cnt==k){
                return root.val;
                //break;
            }
            root=root.right;
        }
        return 0;
    }
}