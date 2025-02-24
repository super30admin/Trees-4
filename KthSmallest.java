//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root ==  null){
            return -1;
        }
        Stack<TreeNode> s = new Stack<>();
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root  = root.right;
        }
        return 8989989;
    }
}