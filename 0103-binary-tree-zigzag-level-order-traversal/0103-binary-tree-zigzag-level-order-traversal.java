/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> response=new ArrayList<>();
        if (root==null) return new ArrayList<>();
        Queue<TreeNode> que=new LinkedList<>();

        que.offer(root);
        boolean leftToright=true;
        while(!que.isEmpty()){
            int nodes=que.size();
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<nodes;i++){
                TreeNode curr=que.poll();
                if(curr.left!=null){
                    que.offer(curr.left);
                }
                if(curr.right!=null){
                    que.offer(curr.right);
                }
                res.add(curr.val);
            }
            if(!leftToright){
                Collections.reverse(res);
            }
            response.add(res);
            leftToright=!leftToright;
        }
        return response;
    }
}