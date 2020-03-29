# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No





class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(root != null){

        if(p.val < root.val && q.val < root.val){
            root = root.left;
        }

        else if(p.val > root.val && q.val > root.val){
            root = root.right;

        }
        else{
            return root;
        }


    }

        return null;
    }
}