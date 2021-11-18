//Timecomplexity:- O(n);
//spacecomplexity:-O(n)
//did it run on leetcode:- Yes.
//Your code with explanation:- in order traversal of bst gives ascending order storing them in min heap and removing root until k1 equals k.




class Solution {
    ArrayList<Integer> cache=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
       
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
            inorder(root);
        int k1=1;
        for(int m=0;m<cache.size();m++){
            minheap.add(cache.get(m));
        }
        while(k1<k){
            minheap.poll();
            k1++;
        }
        return minheap.peek();
    }
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        cache.add(root.val);
        inorder(root.right);
    }
}