/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 236. Lowest Common Ancestor of a Binary Tree
/*
Ran on leetcode: Yes
TC: O(n) SC: O(h)
Traverse,saving the path and when the element is found save its individual path in seperate list. Compare two list to check where the first differing element is found and return it.
*/
class Solution {

    private List<TreeNode> resPathQ;
    private List<TreeNode> resPathP;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        helper(root, p, q, new ArrayList<>());


        for(int i = 0; i < resPathQ.size(); i++){
            if(resPathQ.get(i) != resPathP.get(i)){
                return resPathQ.get(i - 1);
            }
        }

        return null;
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        
        if(root == null) return;

        path.add(root); // Add element

        if(root == p){ // Element found save the path
            resPathP = new ArrayList<>(path);
            resPathP.add(root);
        }

        if(root == q){ // Element found save the path
            resPathQ = new ArrayList<>(path);
            resPathQ.add(root);
        }

        // Traverse left
        helper(root.left, p, q, path);
        // Traverse right
        helper(root.right, p, q, path);

        path.remove(path.size() - 1);
    }   
}