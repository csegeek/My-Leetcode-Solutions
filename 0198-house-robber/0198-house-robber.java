class Solution {
    public int rob(int[] nums) {
        // int[] dp=new int[nums.length+1];
        // Arrays.fill(dp,-1);
        // return recursiveSol(nums,0,0,dp);
        return tabulation(nums);
    }
    // Memoization
    int recursiveSol(int [] nums,int index,int max,int [] dp){
       if(index>=nums.length) return max;
       if(dp[index]!=-1) return dp[index];
       int left=nums[index]+recursiveSol(nums,index+2,max,dp);
       int right=recursiveSol(nums,index+1,max,dp);
       max+=Math.max(left,right);
       return dp[index]=max;
    }

    //Tabulation
    private int tabulation(int [] nums){
        int[] dp=new int [nums.length];
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }

}