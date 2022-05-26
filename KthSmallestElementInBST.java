//TC = O(N)
//SC = O(K)

/*

    Approach : Max Heap is used to find out Kth smallest element.

*/


import java.util.*;
public class KthSmallestElementInBST
{

    

    public static int KthSmallest(TreeNode root, int k)
    {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(root == null) return 0;

        helper(root,k,pq);

        return pq.peek();
    }

    private static void helper(TreeNode root,int k,PriorityQueue pq)
    {
        if(root == null)
        {
            return;
        }

        
        if(pq.size()<k)
        {
            pq.add(root.val);
        }
        else if(root.val<(int)pq.peek())
        {
            pq.poll();
            pq.add(root.val);
        }

        helper(root.left,k,pq);
        helper(root.right, k,pq);
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);

        root.left=one;
        root.right=four;
        one.right=two;

        System.out.println(KthSmallest(root, 1));
    }
}