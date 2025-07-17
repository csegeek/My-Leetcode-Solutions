class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return recursiveSol(nums,0,0,dp);
    }

    int recursiveSol(int [] nums,int index,int max,int [] dp){
       if(index>=nums.length) return max;
       if(dp[index]!=-1) return dp[index];
       int left=nums[index]+recursiveSol(nums,index+2,max,dp);
       int right=recursiveSol(nums,index+1,max,dp);
       max+=Math.max(left,right);
       return dp[index]=max;
    }
}