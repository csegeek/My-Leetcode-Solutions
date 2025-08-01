class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 !=0) return false;
        int target=sum/2;
        //Boolean[][] dp=new Boolean[target+1][nums.length];
        //return recursion(target,0,nums,dp);
        return  tabulation(nums,target);
    }
    boolean recursion(int s,int i,int[] nums,Boolean[][] dp){
        if(s==0) return true;
        if(i>=nums.length) return false;
        if(dp[s][i]!=null) return dp[s][i];
        boolean left=false;
        if(s>=nums[i]){
         left=recursion(s-nums[i],i+1,nums,dp) ;
       }
        boolean right= recursion(s,i+1,nums,dp);
        return dp[s][i] =left|| right;
    }

boolean tabulation(int[] nums, int target) {
    int n = nums.length;
    boolean[][] dp = new boolean[n][target + 1];

    // Initialize base case: sum 0 can be achieved by taking nothing
    for (int i = 0; i < n; i++) {
        dp[i][0] = true;
    }

    // Initialize for the first element
    if (nums[0] <= target) {
        dp[0][nums[0]] = true;
    }

    for (int i = 1; i < n; i++) {
        for (int sum = 1; sum <= target; sum++) {
            boolean notTake = dp[i - 1][sum];
            boolean take = false;
            if (sum >= nums[i]) {
                take = dp[i - 1][sum - nums[i]];
            }
            dp[i][sum] = take || notTake;
        }
    }

    return dp[n - 1][target];
}

}