class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recursion(0,nums.length-1,nums,target);
    }

    public int recursion(int sum,int i,int[] nums,int target){
        if(i==0){
        if(sum+nums[i]==target && sum-nums[i]==target) return 2;
        if(sum+nums[i]==target || sum-nums[i]==target) return 1;
        return 0;
        }
       int sumw= recursion(sum+nums[i],i-1,nums,target);
       int subt=recursion(sum-nums[i],i-1,nums,target);
       return sumw+subt;
    }
}