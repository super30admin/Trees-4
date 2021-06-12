/* Approach: 
Since this is a binary search tree, lowest common ancester withh always be the node that satisfies the condition of one nodes value being less than the nodes and one nodes value being larger than the node 
We can recursively traverse the tree and reduce the search space by half.
If current nodes value is greater than both nodes values, than the node we are looking for would be in the left half. And vice versa.
In any other condition, we have found the root.

Time complexity: O(H), in worst case, we would traverese the length
Space complexity: O(1)
*/
public class LcaOfBstIterative {
    TreeNode rootToReturn;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true)
        {
            if(p.val > root.val && q.val > root.val)
                root = root.right;
            else if(p.val < root.val && q.val < root.val)
                root = root.left;
            else
                return root;
        }
    }
}
