// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class LowestCommonAncestoraBinarySearchTree {
    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            int pVal=p.val, qVal=q.val;//get p and q values

            TreeNode node = root;//start at root node

            while(node != null){

                int parentNode = node.val; //parent/ancestor node

                if(pVal>parentNode && qVal>parentNode){//move right if p and q greater than parent
                    node = node.right;
                }else if(pVal<parentNode && qVal<parentNode){//move left if p and q less than parent
                    node=node.left;
                }else{
                    return node; //ancestor found
                }
            }

            return null; //no ancestor found
        }
    }

}
