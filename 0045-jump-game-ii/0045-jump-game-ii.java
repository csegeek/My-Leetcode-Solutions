class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

     private int recursive(int[] nums,int ind,int count){
       if(ind>=nums.length-1) return count;
        int minc=Integer.MAX_VALUE;
        for(int stp=1;stp<=nums[ind];stp++){
           minc=Math.min(recursive(nums,ind+stp,count+1),minc);
        }
        return minc;
    }
}