class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recursion(0,0,nums,target);
    }

    public int recursion(int sum,int i,int[] nums,int target){
        if(i>=nums.length){
        if(sum==target) return 1;
        return 0;
        }
       int sumw= recursion(sum+nums[i],i+1,nums,target);
       int subt=recursion(sum-nums[i],i+1,nums,target);
       return sumw+subt;


    }
}