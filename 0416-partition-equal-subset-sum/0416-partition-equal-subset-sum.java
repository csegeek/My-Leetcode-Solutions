class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 !=0) return false;
        int target=sum/2;
        Boolean[][] dp=new Boolean[target+1][nums.length];
        return recursion(target,0,nums,dp);
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
}