//Time Complexity: O(n) We might have to visit all the node
//Space Complexity : O(h) height of the tree
//Runs successfully on leetcode
//No Problem

//As the tree is a BST, doing in order traversal on the tree will return all the elements in ascending order
//While traversing each elements, we'll be decreasing the count
//When the count reaches 0, we'll return the element


public class Trees_4_Problem_1_KthSmallestBST {

    int count;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return answer;
    }

    public void inOrder(TreeNode root)
    {
        if(root == null) return;
        inOrder(root.left);
        count--;
        if(count == 0)
        {
            answer = root.val;
            return;
        }
        inOrder(root.right);

    }
}
