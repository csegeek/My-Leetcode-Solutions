class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int [nums.length];
        int[] dp2=new int [nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(recursion(0,n-2,nums,dp1),recursion(1,n-1,nums,dp2));
    }

    int recursion(int i,int end, int[] nums,int [] dp) {
    if (i > end) return 0;
    if(dp[i]!=-1) return dp[i];
    int rob = nums[i] + recursion(i + 2,end, nums,dp);
    int skip = recursion(i + 1,end, nums,dp);
    return dp[i]=Math.max(rob, skip);
    }
}